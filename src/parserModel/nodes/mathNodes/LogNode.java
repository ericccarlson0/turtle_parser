package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import visualizer.VisualContext;

public class LogNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return Math.log(myArgumentNode.execute(context));
    }
}
