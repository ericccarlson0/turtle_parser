package parserModel.nodes.mathNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

public class ProductNode extends BinaryOperationNode {
    public double execute(VisualContext context) {
        return operand1.execute(context) * operand2.execute(context);
    }
}