package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the inverse tangent of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class ArctanNode extends UnaryOperationNode {
    private static final double RADIANS_TO_DEGREES = 180/Math.PI;

    public double execute(TurtleContext context) {
        return RADIANS_TO_DEGREES * Math.atan(myArgumentNode.execute(context));
    }
}
