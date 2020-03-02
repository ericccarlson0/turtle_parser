package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the additive inverse of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class MinusNode extends UnaryOperationNode {
    public double execute(TurtleContext context) { return -1 * myArgumentNode.execute(context); }
}
