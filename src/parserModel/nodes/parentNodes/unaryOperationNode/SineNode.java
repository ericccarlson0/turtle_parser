package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the sine of its child (in degrees)
 *
 * @author Mariusz Derezinski-Choo
 */
public class SineNode extends UnaryOperationNode {
    private static final double RADIANS_TO_DEGREES = Math.PI/180.0;

    public SineNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        return Math.sin(node.execute(context) * RADIANS_TO_DEGREES);
    }
}
