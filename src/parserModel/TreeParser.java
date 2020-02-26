package parserModel;

import execution.Executable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import parserModel.control.ListEndNode;
import parserModel.control.LoopCounterNode;
import parserModel.control.VariableNode;
import parserModel.TokenAnalyzer.TokenType;

public class TreeParser {
    private TokenAnalyzer myTokenAnalyzer;
    private TurtleNodeFactory myCommandFactory;
    private List<Executable> myQueue;

    public TreeParser(List<Executable> queue) {
        myQueue = queue;
        myTokenAnalyzer = new TokenAnalyzer();
        myCommandFactory = new TurtleNodeFactory();
    }

    public CommandParserNode parseString(String input){
        List<String> inputElements = new ArrayList<>(Arrays.asList(input.split(" ")));
        for(int i = 0; i < inputElements.size(); i++) {
            if(inputElements.get(i).equals("")){
                inputElements.remove(i);
                i--;
            }
        }
        System.out.println(inputElements); // *** testing...
        return parseList(inputElements);
    }

    private CommandParserNode parseList(List<String> input){
        InputIterator iterator = new InputIterator(input);
        RootParserNode root = new RootParserNode();
        while(iterator.hasNext()) {
            root.addNode(parseIteratorElement(iterator));
        }
        return root;
    }

    /**
     * This is a recursive method that leverages a tree-like data structure to correctly order the
     * various commands.
     */
    private ParserNode parseIteratorElement(InputIterator iterator) {
        String nextElement = iterator.next();
        TokenType tokenType = myTokenAnalyzer.typeOfToken(nextElement);
        System.out.println(tokenType);

        return getParserNode(iterator, nextElement, tokenType);
    }

    private ParserNode parseForSpecificNode(InputIterator iterator, TokenType nodeType){
        String nextElement = iterator.next();
        TokenType tokenType = myTokenAnalyzer.typeOfToken(nextElement);
        if(tokenType != nodeType){
            System.out.println("Exception!");
        } else {
            return getParserNode(iterator, nextElement, tokenType); //TODO
        }
        return null;
    }
    private LoopCounterNode parseForLoopCounter(InputIterator iterator){
        if(myTokenAnalyzer.typeOfToken(iterator.next()) != TokenType.ListStart){
            // TODO: throw an exception
        }
        String variableName = iterator.next();
        if(myTokenAnalyzer.typeOfToken(variableName) != TokenType.Variable){
            //throw an exception
        }
        VariableNode variableNode = new VariableNode(variableName);
        LoopCounterNode loopCounter = new LoopCounterNode(variableNode);
        ParserNode adding;
        while((adding = parseIteratorElement(iterator))
                .typeOfNode()
                != ParserNode.NodeType.LIST_END){
            loopCounter.addNode(adding);
        }
        return loopCounter;
    }
    private ParserNode getParserNode(InputIterator iterator, String nextElement, TokenType tokenType) {
        switch (tokenType) {
            case Command:
                String key = myTokenAnalyzer.getTokenKey(nextElement);
                ParserNode root = myCommandFactory.createCommand(key, myQueue);
                if(root.typeOfNode() == ParserNode.NodeType.LOOP){
                    root.addNode(parseForLoopCounter(iterator));
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
                CommandParserNode list = new RootParserNode();
                ParserNode listElement = parseIteratorElement(iterator);
                while (listElement.typeOfNode() != ParserNode.NodeType.LIST_END) {
                    list.addNode(listElement);
                    listElement = parseIteratorElement(iterator);
                }
                return list;
            case ListEnd:
                return new ListEndNode();
            case GroupStart:
                // TODO
            case GroupEnd:
                // TODO
        }
        return null; //FIXME
    }
}
