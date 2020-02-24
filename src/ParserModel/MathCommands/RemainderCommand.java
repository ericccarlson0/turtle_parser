package ParserModel.MathCommands;

import ParserModel.BinaryOperationNode;

public class RemainderCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return firstOperand.execute() % secondOperand.execute();
    }
}
