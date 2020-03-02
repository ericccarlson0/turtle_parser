package parserModel.nodes.control;

import parserModel.GlobalData;
import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;

import parserModel.TurtleContext;

import java.util.ArrayList;
import java.util.List;

/**
 * A Node that defines a new command.
 *
 * @author Mariusz Derezinski-Choo
 */
public class UserDefinedCommandNode implements ParserNode {
    private static final double SUCCESS = 1.0;

    private List<VariableNode> myVariables;
    private ParserNode myExecutionNode;
    private String myCommandName;

    public UserDefinedCommandNode(){
        this(null);
    }

    public UserDefinedCommandNode(String name){
        myVariables = new ArrayList<>();
        myCommandName = name;
    }

    /**
     * Add a variable parameter to the new command. this variable
     * must be set before each time this command is called
     * @param node the variable that will be added to the parameter list
     */
    public void addVariable(VariableNode node){
        myVariables.add(node);
    }

    @Override
    public void addNode(ParserNode node) {
        myExecutionNode = node;

    }

    @Override
    public double execute(TurtleContext context) {
        CallCommandNode newCommand = new CallCommandNode(myVariables, myExecutionNode);
        GlobalData.getInstance().setCommand(myCommandName, newCommand);
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return myExecutionNode != null;
    }

    @Override
    public NodeType typeOfNode() {
        return NodeType.FUNCTION_DEFINITION;
    }
}
