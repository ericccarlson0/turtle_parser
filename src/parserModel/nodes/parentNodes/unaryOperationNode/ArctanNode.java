package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the inverse tangent of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class ArctanNode extends UnaryOperationNode {
    private static final double RADIANS_TO_DEGREES = 180/Math.PI;

    /**
     * Construct an ArcTanNode
     * @param text the user-inputted text associated with this construction
     */
    public ArctanNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        return RADIANS_TO_DEGREES * Math.atan(node.execute(context));
    }
}
