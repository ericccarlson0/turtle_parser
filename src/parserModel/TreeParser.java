package parserModel;

import java.util.Arrays;
import java.util.List;
import parserModel.TokenAnalyzer.TokenType;

public class TreeParser {
//    private static final ResourceBundle COMMANDS = Main.RESOURCES;
//    private static final ResourceBundle REGEX = Main.SYNTAX;
    private TokenAnalyzer myTokenAnalyzer;
    private CommandFactory myCommandFactory;


    public TreeParser() {
        myTokenAnalyzer = new TokenAnalyzer();
        myCommandFactory = new CommandFactory();
    }

    public ParserNode parseString(String input){
        List<String> inputElements = Arrays.asList(input.split(" "));
        for(int i = 0; i < inputElements.size(); i++) {
            if(inputElements.get(i).equals("")){
                inputElements.remove(i);
                i--;
            }
        }
        System.out.println(inputElements); // *** testing...
        return parseList(inputElements);
    }

    private ParserNode parseList(List<String> input){
        InputIterator iterator = new InputIterator(input);
        RootParserNode root = new RootParserNode();
        while(iterator.hasNext()) {
            root.addNode(parseIteratorElement(iterator, root));
        }
        return root;
    }

    /**
     * This is a recursive method that leverages a tree-like data structure to correctly order
     * commands.
     */
    private ParserNode parseIteratorElement(InputIterator iterator, ParserNode parent) {
        String nextElement = iterator.next();
        TokenType tokenType = myTokenAnalyzer.typeOfToken(nextElement);
        switch (tokenType) {
            case Command:
                String key = myTokenAnalyzer.getTokenKey(nextElement);
                ParserNode root = myCommandFactory.createCommand(key);
                while(! root.isComplete()) {
                    // This will go through the iterator until the root has its conditions
                    // (parameters, etc.) satisfied.
                    root.addNode(parseIteratorElement(iterator, root));
                }
                return root;
            case Comment:
                // Necessary because a comment can end a block of code...
                if (iterator.hasNext()) {
                    return parseIteratorElement(iterator, parent);
                }
            case Constant:
                return new ConstantNode(Double.parseDouble(nextElement));
            case Variable:
                //TODO: parse variable
            case ListStart:
                ParserNode list = new RootParserNode();
                ParserNode listElement = parseIteratorElement(iterator, list);
                while(listElement != null) {
                    list.addNode(listElement);
                    listElement = parseIteratorElement(iterator, list);
                }
                return list;
            case ListEnd:
                return null;
            case GroupStart:
                //TODO: parse group start
            case GroupEnd:
                //TODO: parse group end
        }
//        System.out.println(nextElement);
//        if(nextElement.equals("Forward")){
//            return new MoveAction(Double.parseDouble(iterator.next()));
//        }
        return null; //FIXME
    }
}
