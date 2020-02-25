package parserModel.MathCommands;

import parserModel.BinaryOperationNode;

public class DifferenceCommand extends BinaryOperationNode {

    public DifferenceCommand(){
        super();
    }

    @Override
    public double execute() {
        return operand1.execute() - operand2.execute();
    }
}
