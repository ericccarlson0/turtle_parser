package parserModel.control;

import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;

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
    public double execute() {
        double executeValue = myAssignmentNode.execute();
        GlobalData.getInstance().setVariable(myVariableNode.name(),executeValue);
        return executeValue;
    }

    @Override
    public boolean isComplete() {
        return myAssignmentNode != null;
    }
}
