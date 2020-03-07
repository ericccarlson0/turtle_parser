package parserModel.nodes.leafNodes;

import parserModel.nodes.NodeType;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A node that represents a variable. upon execution, the variable value
 * is fetched from global memory
 *
 * @author Mariusz Derezinski-Choo
 */
public class VariableNode extends LeafNode {

    public VariableNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getData().getVariable(myEnteredText);
    }
}
