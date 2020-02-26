package parserModel.nodes.mathNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

public class PowNode extends BinaryOperationNode {
    public double execute(VisualContext context) { return Math.pow(operand1.execute(context), operand2.execute(context)); }
}
