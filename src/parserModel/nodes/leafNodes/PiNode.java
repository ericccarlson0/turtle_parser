package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A Math Node that computes the constant Pi
 *
 * @author Mariusz Derezinski-Choo
 */
public class PiNode extends LeafNode {
    public PiNode(String text) {
        super(text);
    }

    public double execute(TurtleContext context) {
        return Math.PI;
    }
}
