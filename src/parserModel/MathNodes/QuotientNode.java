package parserModel.MathNodes;

import parserModel.BinaryOperationNode;
import visualizer.VisualContext;

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
