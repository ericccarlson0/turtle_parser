package parserModel.MathCommands;

import parserModel.BinaryOperationNode;

public class RemainderCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return firstOperand.execute() % secondOperand.execute();
    }
}
