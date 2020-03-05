package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

/**
 * A node that when executed, rotates the turtle
 * right the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class RightTurnNode extends CommandParserNode {
    private ParserNode myRotationNode;

    public RightTurnNode(){
        super();
        myRotationNode = null;
    }

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
            rotateExecutable.addMove((int)id, startHeading, endHeading);
        }
        context.addToQueue(rotateExecutable);
        return degrees;
    }

    @Override
    public boolean isComplete() {
        return myRotationNode != null;
    }
}
