package ParserModel.BooleanCommands;

import ParserModel.BinaryOperationNode;

public class AndCommand extends BinaryOperationNode{
    @Override
    public double execute() {
        return (firstOperand.execute() != 0 && secondOperand.execute() != 0) ? 1.0 : 0.0;
    }
}
