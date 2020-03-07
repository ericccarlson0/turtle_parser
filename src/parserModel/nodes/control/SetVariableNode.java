package parserModel.nodes.control;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.nodes.SimpleParserNode;
import parserModel.nodes.leafNodes.VariableNode;

/**
 * A Node that sets a variable equal to the value
 * returned by the assignment node
 */
public class SetVariableNode extends SimpleParserNode {
    private VariableNode myVariableNode;
    private ParserNode myAssignmentNode;

    public SetVariableNode(String text){
        super(text);
    }

    /**
     * Construct a SetVariableNode object
     * @param node the Variable that is to be set
     */
    public SetVariableNode(VariableNode node){
        super(node.toString());
        myVariableNode = node;
    }

    @Override
    public void addNode(ParserNode node) {
        if(myAssignmentNode == null){
            myAssignmentNode = node;
        }
    }

    @Override
    public void addVariable(VariableNode node) {
        myVariableNode = node;
    }

    @Override
    public double execute(TurtleContext context) {
        double value = myAssignmentNode.execute(context);
        context.getData().setVariable(myVariableNode.toString(), value);
        return value;
    }

    @Override
    public boolean isComplete() {
        return myAssignmentNode != null;
    }
}
