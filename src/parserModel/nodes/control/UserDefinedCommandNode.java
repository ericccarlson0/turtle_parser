package parserModel.nodes.control;

import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.CallCommandNode;
import parserModel.nodes.control.VariableNode;
import visualizer.VisualContext;

import java.util.ArrayList;
import java.util.List;

public class UserDefinedCommandNode extends ParserNode {
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

    @Override
    public void addNode(ParserNode node) {
        myExecutionNode = node;

    }

    public void addVariable(VariableNode node){
        myVariables.add(node);
    }

    @Override
    public double execute(VisualContext context) {
        CallCommandNode newCommand = new CallCommandNode(myVariables, myExecutionNode);
        GlobalData.getInstance().setCommand(myCommandName, newCommand);
        return 1.0; //fixme
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
