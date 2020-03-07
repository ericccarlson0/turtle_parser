package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A leaf node that fetches the index of the current Turtle's shape
 *
 * @author Mariusz Derezinski-Choo
 */
public class ShapeNode extends LeafNode {

    /**
     * Construct a Shape Node
     * @param text the user-inputted text associated with the construction of this Node
     */
    public ShapeNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getWorkingTurtle().getShapeIndex();
    }
}
