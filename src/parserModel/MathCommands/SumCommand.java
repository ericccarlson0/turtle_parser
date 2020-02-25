package parserModel.MathCommands;

import parserModel.BinaryOperationNode;

public class SumCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return operand1.execute() + operand2.execute();
    }
}
