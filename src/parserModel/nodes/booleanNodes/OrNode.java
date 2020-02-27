package parserModel.nodes.booleanNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

/**
 * A Binary Operation Node that returns 1 if
 * either of the operands evaluate to a
 * nonzero value
 *
 * @author Mariusz Derezinski-Choo
 */
public class OrNode extends BinaryOperationNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;
    private static final double FALSE = 0.0;

    @Override
    public double execute(VisualContext context) {
        return (operand1.execute(context) != FALSE || operand2.execute(context) != FALSE) ? RETURN_TRUE : RETURN_FALSE;
    }
}
