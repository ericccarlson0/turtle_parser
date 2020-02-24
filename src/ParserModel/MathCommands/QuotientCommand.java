package ParserModel.MathCommands;

public class QuotientCommand extends BinaryOperationNode
{
    @Override
    public double execute() {
        return firstOperand.execute() / secondOperand.execute();
        //TODO: divide by zero?
    }
}
