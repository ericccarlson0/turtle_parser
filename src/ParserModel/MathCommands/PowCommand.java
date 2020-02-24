package ParserModel.MathCommands;

import ParserModel.BinaryOperationNode;

public class PowCommand extends BinaryOperationNode {

    @Override
    public double execute() {
        return Math.pow(firstOperand.execute(),secondOperand.execute());
    }
}
