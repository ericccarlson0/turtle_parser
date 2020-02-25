package parserModel.MathCommands;

import parserModel.BinaryOperationNode;

public class ProductCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return operand1.execute() * operand2.execute();
    }
}
