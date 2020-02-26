package parserModel.mathNodes;

import parserModel.BinaryOperationNode;
import visualizer.VisualContext;

public class PowNode extends BinaryOperationNode {
    public double execute(VisualContext context) { return Math.pow(operand1.execute(context), operand2.execute(context)); }
}
