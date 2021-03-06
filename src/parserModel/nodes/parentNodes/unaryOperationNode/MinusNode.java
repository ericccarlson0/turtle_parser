package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the additive inverse of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class MinusNode extends UnaryOperationNode {

    /**
     * Construct a Minus Node
     * @param text the user-inputted text associated with this construction
     */
    public MinusNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        return -1 * node.execute(context);
    }
}
