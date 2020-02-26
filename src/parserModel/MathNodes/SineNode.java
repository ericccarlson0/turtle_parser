package parserModel.MathNodes;

import parserModel.UnaryOperationNode;
import visualizer.VisualContext;

public class SineNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return Math.sin(myArgumentNode.execute(context) * Math.PI/180.0);
    }
}
