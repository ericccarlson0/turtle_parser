package ParserModel.MathCommands;

public class ProductCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return firstOperand.execute() * secondOperand.execute();
    }
}
