package parserModel.nodes.turtleNodes;

import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * right the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class RightTurnNode extends TurnNode {

    @Override
    protected void turn(TurtleData td, double degrees) {
        td.turnCounterClockwise(degrees);
    }

    @Override
    public boolean isComplete() {
        return myRotationNode != null;
    }
}
