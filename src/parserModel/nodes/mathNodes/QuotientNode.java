package parserModel.nodes.mathNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

/**
 * A Math Node that computes the quotient of its children
 * special care is taken to ensure division by zero is handled
 *
 * @author Mariusz Derezinski-Choo
 */
public class QuotientNode extends BinaryOperationNode {
    public double execute(VisualContext context) {
        double o1 = operand1.execute(context);
        double o2 = operand2.execute(context);
        if (o1 == 0.0) {
            return 0.0;
        } else if (o2 == 0.0) {
            return Double.MAX_VALUE; // Divide by zero.
        }
        return operand1.execute(context) / operand2.execute(context);
    }
}
