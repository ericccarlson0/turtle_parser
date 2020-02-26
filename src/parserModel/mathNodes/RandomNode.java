package parserModel.mathNodes;

import parserModel.UnaryOperationNode;
import visualizer.VisualContext;

public class RandomNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return Math.random() * myArgumentNode.execute(context);
    }
}
