package parserModel.BooleanCommands;

import parserModel.BinaryOperationNode;

public class NotEqualCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return (firstOperand.execute() != secondOperand.execute()) ? 1.0 : 0.0;
    }
}
