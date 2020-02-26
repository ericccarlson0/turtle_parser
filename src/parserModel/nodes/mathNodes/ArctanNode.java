package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import visualizer.VisualContext;

public class ArctanNode extends UnaryOperationNode {
    public double execute(VisualContext context) {
        return (180/Math.PI) * Math.atan(myArgumentNode.execute(context) * Math.PI/180);
    }
}