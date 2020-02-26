package parserModel.BooleanNodes;

import parserModel.UnaryOperationNode;
import visualizer.VisualContext;

public class NotNode extends UnaryOperationNode {
    public double execute(VisualContext context) { return (myArgumentNode.execute(context) == 0) ? 1.0 : 0.0; }
}
