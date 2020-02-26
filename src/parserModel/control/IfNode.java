package parserModel.control;

import parserModel.BinaryOperationNode;
import visualizer.VisualContext;

public class IfNode extends BinaryOperationNode {
    @Override
    public double execute(VisualContext context) {
        if(operand1.execute(context) != 0){
            return operand2.execute(context);
        }
        return 0.0;
    }
}
