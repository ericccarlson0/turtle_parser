package parserModel.mathNodes;

import parserModel.BinaryOperationNode;

public class DifferenceNode extends BinaryOperationNode {
    public double execute() {
        return operand1.execute() - operand2.execute();
    }
}
