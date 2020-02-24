package ParserModel.MathCommands;

import ParserModel.BinaryOperationNode;

public class QuotientCommand extends BinaryOperationNode
{
    @Override
    public double execute() {
        return firstOperand.execute() / secondOperand.execute();
        //TODO: divide by zero?
    }
}
