package parserModel.nodes.turtleNodes;

import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * left the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class LeftTurnNode extends TurnNode {
    @Override
    protected void turn(TurtleData td, double degrees) {
        td.turnClockwise(degrees);
    }
}
