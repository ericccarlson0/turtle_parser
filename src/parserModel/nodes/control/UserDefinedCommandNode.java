package parserModel.nodes.control;

import parserModel.exceptions.CommandMissingListStartException;
import parserModel.nodes.ParserNode;

import parserModel.TurtleContext;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.SpecialCharacters;
import parserModel.nodes.leafNodes.VariableNode;

import java.util.ArrayList;
import java.util.List;

/**
 * A Node that defines a new command.
 *
 * @author Mariusz Derezinski-Choo
 */
public class UserDefinedCommandNode extends SimpleParserNode {
    private static final double SUCCESS = 1.0;

    private List<VariableNode> myVariables;
    private ListParserNode myExecutionNode;
    private String myCommandName;
    private int stage;


    public UserDefinedCommandNode(String text){
        super(text);
        myVariables = new ArrayList<>();
        myExecutionNode = new ListParserNode();
        stage = 0;
    }

    /**
     * Add a variable parameter to the new command. this variable
     * must be set before each time this command is called
     * @param node the variable that will be added to the parameter list
     */
    @Override
    public void addVariable(VariableNode node){
        if(stage == 2) {
            myVariables.add(node);
        } else{
            addNode(node);
        }
    }

    @Override
    public void addNode(ParserNode node) {
        System.out.println("" + stage);
        switch(stage){
            case 0:
                myCommandName = node.toString();
                stage++;
                break;
            case 1:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new CommandMissingListStartException();
                }
                stage++;
                break;
            case 2:
                if(node.equals(SpecialCharacters.CLOSE_BRACKET)){
                    stage++;
                }
                break;
            case 3:
                if(!node.equals(SpecialCharacters.OPEN_BRACKET)){
                    throw new CommandMissingListStartException();
                }
                stage++;
                break;
            case 4:
                System.out.println("adding node " + node + "to definition body");
                myExecutionNode.addNode(node);
        }


    }

    @Override
    public double execute(TurtleContext context) {
        CallCommandNode newCommand = new CallCommandNode(myVariables, myExecutionNode);
        context.getData().setCommand(myCommandName, newCommand);
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return myExecutionNode.isComplete();
    }
}
