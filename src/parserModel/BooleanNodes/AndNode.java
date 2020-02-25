package parserModel.BooleanNodes;

import parserModel.BinaryOperationNode;

public class AndNode extends BinaryOperationNode{
    public double execute() {
        return (operand1.execute() != 0 && operand2.execute() != 0) ? 1.0 : 0.0;
    }
}