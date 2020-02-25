package parserModel.MathCommands;

import parserModel.BinaryOperationNode;

public class QuotientCommand extends BinaryOperationNode
{
    @Override
    public double execute() {
        return firstOperand.execute() / secondOperand.execute();
        //TODO: divide by zero?
    }
}
