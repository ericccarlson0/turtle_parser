package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes a random variable between zero and the result of
 * its child, inclusive of 0 but exclusive of the child
 *
 * @author Mariusz Derezinski-Choo
 */
public class RandomNode extends UnaryOperationNode {
    public double execute(TurtleContext context) {
        return Math.random() * myArgumentNode.execute(context);
    }
}
