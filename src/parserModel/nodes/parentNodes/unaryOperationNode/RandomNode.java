package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes a random variable between zero and the result of
 * its child, inclusive of 0 but exclusive of the child
 *
 * @author Mariusz Derezinski-Choo
 */
public class RandomNode extends UnaryOperationNode {

    /**
     * Construct a Random Node
     * @param text the user-inputted text associated with this construction
     */
    public RandomNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        return Math.random() * node.execute(context);
    }
}
