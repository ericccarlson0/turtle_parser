package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import visualizer.VisualContext;

/**
 * A Math Node that computes the additive inverse of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class MinusNode extends UnaryOperationNode {
    public double execute(VisualContext context) { return -1 * myArgumentNode.execute(context); }
}
