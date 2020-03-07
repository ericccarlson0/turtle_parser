package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
import parserModel.TurtleContext;
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

    public double execute(TurtleContext context) {
        double degrees = myRotationNode.execute(context);
        RotateExecutable rotateExecutable = new RotateExecutable();
        for (double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startHeading = td.getHeading();
            td.turnCounterClockwise(degrees);
            double endHeading = td.getHeading();
            rotateExecutable.addMove((int) id, startHeading, endHeading);
        }
        rotateExecutable.setName(commandNameResource.getString("Right")+" "+ degrees);

        context.addToQueue(rotateExecutable);
        return degrees;
    }
    protected void turn(TurtleData td, double degrees) {
        td.turnCounterClockwise(degrees);
    }

    @Override
    public boolean isComplete() {
        return myRotationNode != null;
    }
}
