package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import visualizer.VisualContext;

/**
 * A Math Node that computes the natural logarithm of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class LogNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return Math.log(myArgumentNode.execute(context));
    }
}
