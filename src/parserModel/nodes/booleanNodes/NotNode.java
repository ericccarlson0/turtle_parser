package parserModel.nodes.booleanNodes;

import parserModel.nodes.UnaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Unary Operation Node that returns 1 only if the
 * sole operand evaluates to 0, and 1 otherwise
 *
 * @author Mariusz Derezinski-Choo
 */
public class NotNode extends UnaryOperationNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;
    private static final double FALSE = 0.0;

    public double execute(TurtleContext context) { return (myArgumentNode.execute(context) == FALSE) ? RETURN_TRUE : RETURN_FALSE; }
}
