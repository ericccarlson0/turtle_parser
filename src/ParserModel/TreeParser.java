package ParserModel;

import slogo.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import ParserModel.TokenAnalyzer.TokenType;

public class TreeParser {
    private static final ResourceBundle COMMANDS = Main.RESOURCES;
    private static final ResourceBundle REGEX = Main.SYNTAX;

    private TokenAnalyzer myTokenAnalyzer;

    public TreeParser(){
        myTokenAnalyzer = new TokenAnalyzer();
    }

    public ParserNode parse(String input){
        List<String> inputElements = new ArrayList<>();
        inputElements.addAll(Arrays.asList(input.split(" ")));
        //remove white spaces
        int index = 0;
        while (index < inputElements.size()) {
            if(inputElements.get(index).equals("")){
                inputElements.remove(index);
            } else{
                index++;
            }
        }

        System.out.println(inputElements);
        return parse(inputElements);
    }

    private ParserNode parse(List<String> input){
        InputIterator inputs = new InputIterator(input);
        RootParserNode root = new RootParserNode();
        while(inputs.hasNext()){
            root.addNode(recursiveParse(inputs));
        }
        return root;
    }

    private ParserNode recursiveParse(InputIterator iterator){
        String nextCommand = iterator.next();
        TokenType tokenType = myTokenAnalyzer.typeOfToken(nextCommand);
        switch(tokenType){
            case Command:
                ParserNode root = new CommandFactory().createCommand(myTokenAnalyzer.getKey(nextCommand));
                while(! root.isComplete()){
                    root.addNode(recursiveParse(iterator));
                }
                return root;
            case Comment:
                return recursiveParse(iterator); // just keep going
            case GroupEnd:
                break;
            case Constant:
                return new ConstantNode(Double.parseDouble(nextCommand));
            case ListEnd:
                return null; //FIXME
            case Variable:
                break;
            case GroupStart:
                break;
            case ListStart:
                ParserNode myGroup = new RootParserNode();
                ParserNode adding;
                while((adding = recursiveParse(iterator)) != null){
                    myGroup.addNode(adding);
                }
                return myGroup;
        }

        /*
        System.out.println(nextCommand);
        if(nextCommand.equals("Forward")){
            return new MoveAction(Double.parseDouble(iterator.next()));
        }
        */
        return null; //FIXME
    }

}
