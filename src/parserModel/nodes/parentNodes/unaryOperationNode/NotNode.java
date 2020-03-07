package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;

/**
 * A Unary Operation Node that returns 1 only if the
 * sole operand evaluates to 0, and 1 otherwise
 *
 * @author Mariusz Derezinski-Choo
 */
public class NotNode extends UnaryOperationNode {
    private static final double TRUE = 1.0;
    private static final double FALSE = 0.0;

    public NotNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        return (node.execute(context) == FALSE) ? TRUE : FALSE;
    }
}
