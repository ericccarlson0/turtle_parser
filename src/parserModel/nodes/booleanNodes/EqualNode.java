package parserModel.nodes.booleanNodes;

import parserModel.nodes.BinaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Binary Operation Node that checks for
 * equality between two nodes, returnin 1 only
 * if both nodes evaluate to the same quantiy, and
 * 0 otherwise
 *
 * @author Mariusz Derezinski-Choo
 */
public class EqualNode extends BinaryOperationNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    public double execute(TurtleContext context) {
        return (operand1.execute(context) == operand2.execute(context)) ? RETURN_TRUE : RETURN_FALSE;
    }
}
