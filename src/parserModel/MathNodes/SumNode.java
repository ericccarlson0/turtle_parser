package parserModel.MathNodes;

import parserModel.BinaryOperationNode;

public class SumNode extends BinaryOperationNode {
    public double execute() {
        return operand1.execute() + operand2.execute();
    }
}
