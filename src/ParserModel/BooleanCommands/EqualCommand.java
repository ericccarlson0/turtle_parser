package ParserModel.BooleanCommands;

import ParserModel.BinaryOperationNode;

public class EqualCommand extends BinaryOperationNode {
    @Override
    public double execute() {
        return (firstOperand.execute() == secondOperand.execute()) ? 1.0 : 0.0;
    }
}
