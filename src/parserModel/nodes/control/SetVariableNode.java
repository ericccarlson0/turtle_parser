package parserModel.nodes.control;

import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Node that sets a variable equal to the value
 * returned by the assignment node
 */
public class SetVariableNode extends CommandParserNode {
    private VariableNode myVariableNode;
    private ParserNode myAssignmentNode;

    /**
     * Construct a SetVariableNode object
     * @param node the Variable that is to be set
     */
    public SetVariableNode(VariableNode node){
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
        double value = myAssignmentNode.execute(context);
        context.getData().setVariable(myVariableNode.name(), value);
        return value;
    }

    @Override
    public boolean isComplete() {
        return myAssignmentNode != null;
    }
}
