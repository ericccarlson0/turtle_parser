package parserModel.BooleanCommands;

import parserModel.BinaryOperationNode;

public class AndCommand extends BinaryOperationNode{
    @Override
    public double execute() {
        return (operand1.execute() != 0 && operand2.execute() != 0) ? 1.0 : 0.0;
    }
}
