package parserModel.BooleanCommands;

import parserModel.BinaryOperationNode;

public class OrCommand extends BinaryOperationNode {
    @Override
    public double execute() {
        return (firstOperand.execute() != 0 || secondOperand.execute() != 0) ? 1.0 : 0.0;
    }
}
