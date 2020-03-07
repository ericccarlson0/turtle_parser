package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

/**
 * A leaf node that fetched the number of active turtles
 *
 * @author Mariusz Derezinski-Choo
 */
public class TurtlesNode extends LeafNode {
    /**
     * Construct a TurtlesNode object
     * @param text the user-inputted text associated with the construction of this Node
     */
    public TurtlesNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getData().getAllTurtles().size();
    }
}
