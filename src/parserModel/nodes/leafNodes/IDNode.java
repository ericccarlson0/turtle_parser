package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A Leaf Node that when executed, returns the value of the currently active turtle's id
 *
 * @author Mariusz Derezinski-Choo
 */
public class IDNode extends LeafNode {

    /**
     * Construct a Leaf Node object
     * @param text the user-inputted text associated with this call to id
     */
    public IDNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getWorkingID();
    }
}
