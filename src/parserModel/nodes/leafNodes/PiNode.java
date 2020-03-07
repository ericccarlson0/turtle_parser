package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A Math Node that computes the constant Pi
 *
 * @author Mariusz Derezinski-Choo
 */
public class PiNode extends LeafNode {
    /**
     * Construct a PI object
     * @param text the user-inputted text associated with the construction of this Node
     */
    public PiNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return Math.PI;
    }
}
