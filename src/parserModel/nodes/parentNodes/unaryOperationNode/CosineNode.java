package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that returns the cosine of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class CosineNode extends UnaryOperationNode {
    private static final double RADIANS_TO_DEGREES = Math.PI/180.0;

    public CosineNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        return Math.cos(node.execute(context) * RADIANS_TO_DEGREES);
    }
}
