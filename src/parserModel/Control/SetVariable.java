package parserModel.Control;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import parserModel.Variables;

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
        new Variables().setVariable(myVariableNode.name(),executeValue);
        return executeValue;
    }

    @Override
    public boolean isComplete() {
        return myAssignmentNode != null;
    }
}
