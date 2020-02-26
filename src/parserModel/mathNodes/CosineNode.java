package parserModel.mathNodes;

import parserModel.UnaryOperationNode;
import visualizer.VisualContext;

public class CosineNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return Math.cos(myArgumentNode.execute(context) * Math.PI/180.0);
    }
}
