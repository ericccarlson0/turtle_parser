package parserModel.nodes.turtleNodes;

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
    @Override
    public void addNode(ParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }
    @Override
    public double execute(TurtleContext context) {
        double degrees = myRotationNode.execute(context);
        RotateExecutable rotateExecutable = new RotateExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);

            double startHeading = td.getHeading();
            td.turnClockwise(degrees);
            double endHeading = td.getHeading();
            //TODO: throw exception
            rotateExecutable.addMove((int)id, startHeading, endHeading);
        }
        rotateExecutable.setName(commandNameResource.getString("Left")+" "+ degrees);
        context.addToQueue(rotateExecutable);
        return degrees;
    }

    public boolean isComplete() {
        return myRotationNode != null;
    }
    protected void turn(TurtleData td, double degrees) {
        td.turnClockwise(degrees);
    }
}
