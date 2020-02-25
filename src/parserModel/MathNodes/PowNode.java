package parserModel.MathNodes;

import parserModel.BinaryOperationNode;

public class PowNode extends BinaryOperationNode {
    public double execute() { return Math.pow(operand1.execute(), operand2.execute()); }
}
