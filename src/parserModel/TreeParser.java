package parserModel;

import execution.ExecutableSuperClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.ObservableList;
import parserModel.exceptions.*;
import parserModel.nodes.CommandFactory;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.*;
import parserModel.TokenAnalyzer.TokenType;
import parserModel.nodes.mathNodes.ConstantNode;

public class TreeParser {
    private TokenAnalyzer myTokenAnalyzer;
    private CommandFactory myCommandFactory;
    private List<ExecutableSuperClass> myQueue;

    public TreeParser(List<ExecutableSuperClass> queue) {
        myQueue = queue;
        myTokenAnalyzer = new TokenAnalyzer();
        myCommandFactory = new CommandFactory();
    }

    public ParserNode parseString(String input){
        List<String> inputElements = new ArrayList<>(Arrays.asList(input.split(" ")));
        for(int i = 0; i < inputElements.size(); i++) {
            if(inputElements.get(i).equals("")){
                inputElements.remove(i);
                i--;
            }
        }

        return parseList(inputElements);
    }

    private ParserNode parseList(List<String> input){
        InputIterator iterator = new InputIterator(input);
        ListParserNode root = new ListParserNode();
        try {
            while (iterator.hasNext()) {
                root.addNode(parseIteratorElement(iterator));
            }
            return root;
        } catch (ParsingException e){
            return e.toNode();
        }
    }

    /**
     * This is a recursive method that leverages a tree-like data structure to correctly order the
     * various commands.
     */
    private ParserNode parseIteratorElement(InputIterator iterator) {
        String nextElement = iterator.next();
        TokenType tokenType = myTokenAnalyzer.typeOfToken(nextElement);
        return getParserNode(iterator, nextElement, tokenType);
    }

    private LoopCounterNode parseForLoopHeader(InputIterator iterator){
        if(myTokenAnalyzer.typeOfToken(iterator.next()) != TokenType.ListStart){
            throw new InvalidLoopStructureException();
        }
        String variableName = iterator.next();
        if(myTokenAnalyzer.typeOfToken(variableName) != TokenType.Variable){
            throw new NonVariableInLoopHeaderException();
        }
        VariableNode variableNode = new VariableNode(variableName);
        LoopCounterNode loopCounter = new LoopCounterNode(variableNode);
        ParserNode adding;

        while((adding = parseIteratorElement(iterator)).typeOfNode() != NodeType.LIST_END){
            loopCounter.addNode(adding);
        }
        if(loopCounter.isComplete()) {
            return loopCounter;
        } else{
            throw new InvalidLoopHeaderException();
        }
    }
    private UserDefinedCommandNode parseForCommandDefinition(InputIterator iterator){
        String commandName = iterator.next();
        UserDefinedCommandNode newCommand = new UserDefinedCommandNode(commandName); //FIXME

        if (! validateOpenBracket(iterator)){
            throw new CommandMissingListStartException();
        }

        String variableName;
        while(myTokenAnalyzer.typeOfToken((variableName = iterator.next())) != TokenType.ListEnd){
            newCommand.addVariable(new VariableNode(variableName));
        }
        return newCommand;
    }
    private ParserNode getParserNode(InputIterator iterator, String nextElement, TokenType tokenType) {
        switch (tokenType) {
            case Command:
                String key = myTokenAnalyzer.getTokenKey(nextElement);
                ParserNode root = myCommandFactory.createCommand(key);
                if(root.typeOfNode() == NodeType.LOOP){
                    root.addNode(parseForLoopHeader(iterator));
                    root.addNode(parseForLoopBody(iterator));
                } else if(root.typeOfNode() == NodeType.FUNCTION_DEFINITION){
                    root = parseForCommandDefinition(iterator);
                    root.addNode(parseForCommandBody(iterator));
                }
                while(! root.isComplete()) {
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
        }
        return null; //FIXME
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

    private ParserNode parseForList(InputIterator iterator){
        return parseForList(iterator, false, new CommandMissingListStartException());
    }

    private ParserNode parseForList(InputIterator iterator, boolean beginWithBracket, ParsingException missingListException) {
        if(beginWithBracket && !validateOpenBracket(iterator)){
            throw missingListException;
        }

        CommandParserNode list = new ListParserNode();
        ParserNode listElement = parseIteratorElement(iterator);
        while (listElement.typeOfNode() != NodeType.LIST_END) {
            list.addNode(listElement);
            listElement = parseIteratorElement(iterator);
        }
        return list;
    }

    public ObservableList<String> observableVariables(){
        return GlobalData.getInstance().observableVariableList();
    }
    public ObservableList<String> observableCommands(){
        return GlobalData.getInstance().observableCommandList();
    }
}
