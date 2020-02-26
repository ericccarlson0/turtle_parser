package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

public class SetVariable extends CommandParserNode {
    private VariableNode myVariableNode;
    private ParserNode myAssignmentNode;

    public SetVariable(VariableNode node){
        myVariableNode = node;
    }

    @Override
    public void addNode(ParserNode node) {
        if(myAssignmentNode == null){
            myAssignmentNode = node;
        } //FIXME
    }

    @Override
    public double execute(VisualContext context) {
        double executeValue = myAssignmentNode.execute(context);
        GlobalData.getInstance().setVariable(myVariableNode.name(),executeValue);
        return executeValue;
    }

    @Override
    public boolean isComplete() {
        return myAssignmentNode != null;
    }
}
