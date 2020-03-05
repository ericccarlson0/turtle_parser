package parserModel;

import execution.Executable;
import javafx.collections.ObservableList;
import parserModel.TokenAnalyzer.TokenType;
import parserModel.exceptions.CommandMissingListStartException;
import parserModel.exceptions.InvalidLoopHeaderException;
import parserModel.exceptions.InvalidLoopStructureException;
import parserModel.exceptions.MissingCommandBodyException;
import parserModel.exceptions.MissingLoopBodyException;
import parserModel.exceptions.NonVariableInLoopHeaderException;
import parserModel.exceptions.ParsingException;
import parserModel.exceptions.UnidentifiableTokenException;
import parserModel.nodes.CommandFactory;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.ListEndNode;
import parserModel.nodes.control.ListNode;
import parserModel.nodes.control.LoopCounterNode;
import parserModel.nodes.control.UserDefinedCommandNode;
import parserModel.nodes.control.VariableNode;
import parserModel.nodes.mathNodes.ConstantNode;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TreeParser {
    private TokenAnalyzer myTokenAnalyzer;
    private CommandFactory myCommandFactory;
    private TurtleContext myContext;

    public TreeParser() {
        myContext = new TurtleContext();
        myContext.addActiveTurtles(List.of(0.0));
        myTokenAnalyzer = new TokenAnalyzer();
        myCommandFactory = new CommandFactory();
    }

    public Collection<String> getLanguageOptions() {
        return getPropertiesFilenames("src/parserModel/languages/commands");
    }

    public Iterator<Executable> parseString(String input) throws ParsingException {
        String[] inputLines = input.split("\n");
        List<String> inputElements = new ArrayList<>();
        for (String line : inputLines){
            int poundIndex;
            if ((poundIndex = line.indexOf('#')) != -1) {
                line = line.substring(0, poundIndex);
            }
            inputElements.addAll(Arrays.asList(line.split(" ")));
        }
        for (int i = 0; i < inputElements.size(); i++) {
            if (inputElements.get(i).equals("")) {
                inputElements.remove(i);
                i--;
            }
        }
        parseList(inputElements);
        Iterator<Executable> result = myContext.getExecutables();
        myContext.resetQueue();
        return result;
    }

    private void parseList(List<String> input) {
        InputIterator iterator = new InputIterator(input);
        double returning;
        while (iterator.hasNext()) {
            ParserNode returner = parseIteratorElement(iterator);
            System.out.println(returner); // ***
            returning = returner.execute(myContext);
            System.out.println(""+returning); // ***
        }
    }

    /**
     * A recursive method that leverages a tree-like data structure to correctly order and generate
     * various commands.
     */
    private ParserNode parseIteratorElement(InputIterator iterator) {
        String nextElement = iterator.next();
        TokenType tokenType = myTokenAnalyzer.typeOfToken(nextElement);
        return getParserNode(iterator, nextElement, tokenType);
    }

    private LoopCounterNode parseForLoopHeader(InputIterator iterator) {
        if (myTokenAnalyzer.typeOfToken(iterator.next()) != TokenType.ListStart) {
            throw new InvalidLoopStructureException();
        }
        String loopVariable = iterator.next();
        if (myTokenAnalyzer.typeOfToken(loopVariable) != TokenType.Variable) {
            throw new NonVariableInLoopHeaderException();
        }
        VariableNode variableNode = new VariableNode(loopVariable);
        LoopCounterNode loopCounter = new LoopCounterNode(variableNode);
        ParserNode adding;

        while ((adding = parseIteratorElement(iterator)).typeOfNode() != NodeType.LIST_END){
            loopCounter.addNode(adding);
        }
        if (loopCounter.isComplete()) {
            return loopCounter;
        } else {
            throw new InvalidLoopHeaderException();
        }
    }

    private UserDefinedCommandNode parseForCommandDefinition(InputIterator iterator) {
        String nextElement = iterator.next();
        UserDefinedCommandNode newCommand = new UserDefinedCommandNode(nextElement);
        //FIXME

        if (! validateOpenBracket(iterator)) {
            throw new CommandMissingListStartException();
        }

        String commandVariable;
        while (myTokenAnalyzer.typeOfToken((commandVariable = iterator.next()))
            != TokenType.ListEnd) {
            newCommand.addVariable(new VariableNode(commandVariable));
        }
        return newCommand;
    }

    private ParserNode getParserNode(InputIterator iterator, String nextElement, TokenType tokenType) {
        switch (tokenType) {
            case Command:
                String key = myTokenAnalyzer.getTokenKey(nextElement);
                ParserNode root = myCommandFactory.createCommand(key, myContext);
                if (root.typeOfNode() == NodeType.LOOP) {
                    root.addNode(parseForLoopHeader(iterator));
                    root.addNode(parseForLoopBody(iterator));
                } else if (root.typeOfNode() == NodeType.FUNCTION_DEFINITION) {
                    root = parseForCommandDefinition(iterator);
                    root.addNode(parseForCommandBody(iterator));
                } else if (root.typeOfNode() == NodeType.TELL) {
                    validateOpenBracket(iterator);
                    //TODO: throw exception
                }
                while (! root.isComplete()) {
                    root.addNode(parseIteratorElement(iterator));
                }
                return root;
            case Comment:
                if (iterator.hasNext()) {
                    return parseIteratorElement(iterator);
                }
            case Constant:
                return new ConstantNode(Double.parseDouble(nextElement));
            case Variable:
                return new VariableNode(nextElement);
            case ListStart:
                return parseForList(iterator);
            case ListEnd:
                return new ListEndNode();
            case GroupStart:
                // TODO
            case GroupEnd:
                // TODO
            case Error:
                // TODO
            default:
                throw new UnidentifiableTokenException(nextElement);
        }
    }

    private ParserNode parseForCommandBody(InputIterator iterator) {
        return parseForList(iterator, true, new MissingCommandBodyException());
    }

    private ParserNode parseForLoopBody(InputIterator iterator){
        return parseForList(iterator, true, new MissingLoopBodyException());
    }

    private boolean validateOpenBracket(InputIterator iterator){
        return myTokenAnalyzer.typeOfToken(iterator.next()) == TokenType.ListStart;
    }

    private ParserNode parseForList(InputIterator iterator) {
        return parseForList(iterator, false, new CommandMissingListStartException());
    }

    private ListNode parseForList(InputIterator iterator, boolean startWithBracket,
        ParsingException noBracketException) {
        if (startWithBracket && ! validateOpenBracket(iterator)) {
            throw noBracketException;
        }

        ListNode listNode = new ListNode();
        ParserNode listElement = parseIteratorElement(iterator);
        while (listElement.typeOfNode() != NodeType.LIST_END) {
            listNode.addNode(listElement);
            listElement = parseIteratorElement(iterator);
        }
        return listNode;
    }

    private List<String> getPropertiesFilenames(String folderPath) {
        List<String> filenames = new ArrayList<>();
        File[] files = new File(folderPath).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                filenames.add(file.getName().replace(".properties",""));
            }
        }
        return filenames;
    }

    public ObservableList<String> observableVariables(){
        return myContext.getData().observableVariableList();
    }
    public ObservableList<String> observableCommands() {
        return myContext.getData().observableCommandList();
    }

    public void setLanguage(String language) {
        myTokenAnalyzer.setLanguage(language);
    }

    public List<Double> getTurtleSummary (double id) {
        return myContext.getData().turtleData(id).getSummaryList();
    }
}
