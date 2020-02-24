package ParserModel.MathCommands;

public class SumCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return firstOperand.execute() + secondOperand.execute();
    }
}
