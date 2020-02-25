package parserModel.BooleanCommands;

import parserModel.BinaryOperationNode;

public class EqualCommand extends BinaryOperationNode {
    @Override
    public double execute() {
        return (operand1.execute() == operand2.execute()) ? 1.0 : 0.0;
    }
}
