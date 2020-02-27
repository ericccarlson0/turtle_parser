package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import visualizer.VisualContext;

/**
 * A Math Node that computes the sine of its child (in degrees)
 *
 * @author Mariusz Derezinski-Choo
 */
public class SineNode extends UnaryOperationNode {
    private static final double RADIANS_TO_DEGREES = Math.PI/180.0;

    public double execute(VisualContext context) {
        return Math.sin(myArgumentNode.execute(context) * RADIANS_TO_DEGREES);
    }
}
