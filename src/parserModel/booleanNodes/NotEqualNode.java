package parserModel.booleanNodes;

import parserModel.BinaryOperationNode;

public class NotEqualNode extends BinaryOperationNode {
    public double execute() {
        return (operand1.execute() != operand2.execute()) ? 1.0 : 0.0;
    }
}
