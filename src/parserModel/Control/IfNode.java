package parserModel.Control;

import parserModel.BinaryOperationNode;

public class IfNode extends BinaryOperationNode {
    @Override
    public double execute() {
        if(firstOperand.execute() != 0){
            return secondOperand.execute();
        }
        return 0.0;
    }
}
