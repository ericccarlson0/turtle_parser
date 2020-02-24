package ParserModel.MathCommands;

import ParserModel.BinaryOperationNode;

public class ProductCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return firstOperand.execute() * secondOperand.execute();
    }
}
