package parserModel.nodes.mathNodes;

import parserModel.nodes.UnaryOperationNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the tangent of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class TangentNode extends UnaryOperationNode {
    private static final double RADIANS_TO_DEGREES = Math.PI/180.0;

    public double execute(TurtleContext context) {
        return Math.tan(myArgumentNode.execute(context) * RADIANS_TO_DEGREES);
    }
}
