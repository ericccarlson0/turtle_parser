package parserModel.MathNodes;

import parserModel.BinaryOperationNode;
import visualizer.VisualContext;

public class DifferenceNode extends BinaryOperationNode {
    public double execute(VisualContext context) {
        return operand1.execute(context) - operand2.execute(context);
    }
}

