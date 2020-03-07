package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * so that it faces the direction of the heading,
 * determined by its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class SetHeadingNode extends TurnNode {

    /**
     * Construct a SetHeadingNode
     * @param text the user-inputted text associated with this construction
     */
    public SetHeadingNode(String text) {
        super(text);
    }

    @Override
    protected void turn(TurtleData td, double degrees) {
        td.setHeading(degrees);
    }
}
