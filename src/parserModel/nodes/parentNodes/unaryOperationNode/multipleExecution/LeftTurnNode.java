package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * left the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class LeftTurnNode extends TurnNode {

    /**
     * Construct a LeftTurnNode
     * @param text the user-inputted text associated with this construction
     */
    public LeftTurnNode(String text) {
        super(text);
    }

    @Override
    protected void turn(TurtleData td, double degrees) {
        td.turnClockwise(degrees);
    }
}
