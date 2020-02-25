package parserModel.MathNodes;

import parserModel.BinaryOperationNode;

public class QuotientNode extends BinaryOperationNode {
    public double execute() {
        double o1 = operand1.execute();
        double o2 = operand2.execute();
        if (o1 == 0.0) {
            return 0.0;
        } else if (o2 == 0.0) {
            return Double.MAX_VALUE; // Divide by zero.
        }
        return operand1.execute() / operand2.execute();
    }
}
