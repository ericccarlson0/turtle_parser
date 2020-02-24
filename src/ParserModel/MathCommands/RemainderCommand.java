package ParserModel.MathCommands;

public class RemainderCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return firstOperand.execute() % secondOperand.execute();
    }
}
