package parserModel.nodes.turtleNodes;

import execution.ClearExecutable;
import execution.MoveExecutable;
import execution.RotateExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.TurtleData;

import java.util.List;

/**
 * A node that when executed, rotates the turtle
 * left the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class LeftTurnNode extends CommandParserNode {
    private ParserNode myRotationNode;

    public LeftTurnNode(){
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
            td.turnCounterClockwise(degrees);
            double endHeading = td.getHeading();
            //TODO: throw exception
            rotateExecutable.addMove((int)id, startHeading, endHeading);
        }
        context.addToQueue(rotateExecutable);
        return degrees;
    }

    public boolean isComplete() {
        return myRotationNode != null;
    }
}
