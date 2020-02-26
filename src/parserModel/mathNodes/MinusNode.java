package parserModel.mathNodes;

import parserModel.UnaryOperationNode;
import visualizer.VisualContext;

public class MinusNode extends UnaryOperationNode {
    public double execute(VisualContext context) { return -1 * myArgumentNode.execute(context); }
}
