package parserModel.control;

import parserModel.BinaryOperationNode;

public class IfNode extends BinaryOperationNode {
    @Override
    public double execute() {
        if(operand1.execute() != 0){
            return operand2.execute();
        }
        return 0.0;
    }
}
