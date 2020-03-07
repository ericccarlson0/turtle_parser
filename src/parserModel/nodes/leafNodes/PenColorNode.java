package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A leaf node that fetches the index of the current pen color
 *
 * @author Mariusz Derezinski-Choo
 */
public class PenColorNode extends LeafNode {

    /**
     * Construct a PenColor Node
     * @param text the user-inputted text associated with the construction of this Node
     */
    public PenColorNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getWorkingTurtle().getPenColor();
    }
}
