package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * right the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class RightTurnNode extends TurnNode {

    /**
     * Construct a RightTurnNode
     * @param text the user-inputted text associated with this construction
     */
    public RightTurnNode(String text) {
        super(text);
    }

    @Override
    protected void turn(TurtleData td, double degrees) {
        System.out.println("turning: " + degrees);
        td.turnCounterClockwise(degrees);
    }
}
