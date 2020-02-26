package parserModel.nodes.booleanNodes;

import parserModel.nodes.BinaryOperationNode;
import visualizer.VisualContext;

public class AndNode extends BinaryOperationNode{
    public double execute(VisualContext context) {
        return (operand1.execute(context) != 0 && operand2.execute(context) != 0) ? 1.0 : 0.0;
    }
}