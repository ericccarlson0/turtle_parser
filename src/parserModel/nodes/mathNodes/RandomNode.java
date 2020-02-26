package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import visualizer.VisualContext;

public class RandomNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return Math.random() * myArgumentNode.execute(context);
    }
}