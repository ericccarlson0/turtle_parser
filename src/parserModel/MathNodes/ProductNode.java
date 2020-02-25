package parserModel.MathNodes;

import parserModel.BinaryOperationNode;

public class ProductNode extends BinaryOperationNode {
    public double execute() {
        return operand1.execute() * operand2.execute();
    }
}
