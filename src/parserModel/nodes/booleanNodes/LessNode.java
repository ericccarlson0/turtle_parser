package parserModel.nodes.booleanNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

/**
 * A Binary Operation Node that returns 1 only if the
 * first operand evaluates to a value less than the second
 * operand, and 0 otherwise
 *
 * @author Mariusz Derezinski-Choo
 */
public class LessNode extends BinaryOperationNode {
    private static final double RETURN_TRUE = 1.0;
    private static final double RETURN_FALSE = 0.0;

    @Override
    public double execute(VisualContext context) {
        return (operand1.execute(context) < operand2.execute(context)) ? RETURN_TRUE : RETURN_FALSE;
    }
}
