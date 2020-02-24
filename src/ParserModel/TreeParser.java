package ParserModel;

import slogo.Main;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import ParserModel.TokenAnalyzer.TokenType;

public class TreeParser {
    private static final ResourceBundle COMMANDS = Main.RESOURCES;
    private static final ResourceBundle REGEX = Main.SYNTAX;
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
            root.addNode(parseIteratorElement(iterator));
        }
        return root;
    }

    /**
     * NOTE: this is a recursive method
     */
    private ParserNode parseIteratorElement(InputIterator iterator) {
        String nextElement = iterator.next();
        TokenType tokenType = myTokenAnalyzer.typeOfToken(nextElement);
        switch (tokenType) {
            case Command:
                ParserNode root = myCommandFactory.createCommand(myTokenAnalyzer.getTokenKey(nextElement));
                while(! root.isComplete()) {
                    root.addNode(parseIteratorElement(iterator));
                }   // This will go through the iterator until the root has its conditions
                    // (parameters, etc.) satisfied.
                return root;
            case Comment:
                return parseIteratorElement(iterator); // This moves on to the next element.
            case Constant:
                return new ConstantNode(Double.parseDouble(nextElement));
            case Variable:
                //TODO: parse variable
            case ListStart:
                ParserNode group = new RootParserNode();
                ParserNode groupElement;
                while((groupElement = parseIteratorElement(iterator)) != null) {
                    group.addNode(groupElement);
                }
                return group;
            case ListEnd:
                return null; //FIXME
                //TODO: parse list end
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
