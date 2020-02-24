package ParserModel.MathCommands;

public class DifferenceCommand extends BinaryOperationNode {
    @Override
    public double execute() {
        return firstOperand.execute() - secondOperand.execute();
    }
}
