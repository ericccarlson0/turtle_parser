package parserModel.MathNodes;

import parserModel.UnaryOperationNode;
import visualizer.VisualContext;

public class TangentNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return Math.tan(myArgumentNode.execute(context) * Math.PI/180.0);
    }
}
