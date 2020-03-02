package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Node that sets a variable equal to the value
 * returned by the assignment node
 */
public class SetVariable extends CommandParserNode {
    private VariableNode myVariableNode;
    private ParserNode myAssignmentNode;

    /**
     * Construct a SetVariable object
     * @param node the Variable that is to be set
     */
    public SetVariable(VariableNode node){
        myVariableNode = node;
    }

    @Override
    public void addNode(ParserNode node) {
        if(myAssignmentNode == null){
            myAssignmentNode = node;
        }
    }

    @Override
    public double execute(TurtleContext context) {
        double executeValue = myAssignmentNode.execute(context);
        GlobalData.getInstance().setVariable(myVariableNode.name(),executeValue);
        return executeValue;
    }

    @Override
    public boolean isComplete() {
        return myAssignmentNode != null;
    }
}
