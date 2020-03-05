package parserModel;

import execution.Executable;
import javafx.collections.ObservableList;
import parserModel.TokenAnalyzer.TokenType;
import parserModel.exceptions.ParsingException;
import parserModel.exceptions.UnidentifiableTokenException;
import parserModel.nodes.CommandFactory;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;
import parserModel.nodes.SpecialCharacters;
import parserModel.nodes.control.VariableNode;
import parserModel.nodes.mathNodes.ConstantNode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    public Iterator<Executable> saveFile(String input, String filePath){
        try {
            FileWriter out = new FileWriter(filePath);
            out.write(input);
            out.close();
        } catch (IOException e) {
            //TODO
        }
        return null;
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

    private ParserNode getParserNode(InputIterator iterator, String nextElement, TokenType tokenType) {
        switch (tokenType) {
            case Command:
                String key = myTokenAnalyzer.getTokenKey(nextElement);
                ParserNode root = myCommandFactory.createCommand(key, myContext);
                if(root.typeOfNode() == NodeType.TELL){
                    validateOpenBracket(iterator); //TODO: Throw exception
                }
                while(! root.isComplete()) {
                    ParserNode next = parseIteratorElement(iterator);
                    System.out.println("adding element " + next + " to parent " + root);
                    if(next instanceof VariableNode){
                        root.addVariable((VariableNode)next);
                    } else {
                        root.addNode(next);
                    }
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
                return SpecialCharacters.OPEN_BRACKET;
            case ListEnd:
                return SpecialCharacters.CLOSE_BRACKET;
            case GroupStart:
                return SpecialCharacters.GROUP_START;
            case GroupEnd:
                return SpecialCharacters.GROUP_END;
            case Error:
                // TODO
            default:
                throw new UnidentifiableTokenException(nextElement);
        }
    }
    private boolean validateOpenBracket(InputIterator iterator){
        return myTokenAnalyzer.typeOfToken(iterator.next()) == TokenType.ListStart;
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
