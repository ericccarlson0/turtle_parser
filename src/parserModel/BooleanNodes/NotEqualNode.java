package parserModel.BooleanNodes;

import parserModel.BinaryOperationNode;
import visualizer.VisualContext;

public class NotEqualNode extends BinaryOperationNode {
    public double execute(VisualContext context) {
        return (operand1.execute(context) != operand2.execute(context)) ? 1.0 : 0.0;
    }
}
