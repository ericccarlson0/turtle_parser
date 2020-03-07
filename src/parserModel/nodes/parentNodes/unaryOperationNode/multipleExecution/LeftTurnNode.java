package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import execution.RotateExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;

/**
 * A node that when executed, rotates the turtle
 * left the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class LeftTurnNode extends TurnNode {
    public LeftTurnNode(String text) {
        super(text);
    }

    protected void turn(TurtleData td, double degrees) {
        td.turnClockwise(degrees);
    }
}
