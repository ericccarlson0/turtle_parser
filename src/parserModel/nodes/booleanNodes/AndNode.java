package parserModel.nodes.booleanNodes;

import parserModel.nodes.BinaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Binary Operation Node that Ands the two nodes,
 * returning 1 only if both nodes evaluate to a nonzero
 * value
 *
 * @author Mariusz Derezinski-Choo
 */
public class AndNode extends BinaryOperationNode{
    private static final double FALSE = 0;
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    @Override
    public double execute(TurtleContext context) {
        return (operand1.execute(context) != FALSE && operand2.execute(context) != FALSE) ? RETURN_TRUE : RETURN_FALSE;
    }
}