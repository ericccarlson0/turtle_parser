package parserModel.nodes.parentNodes.multiOperation.multiExecution;

import execution.RotateExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A node that when executed, rotates the turtle
 * to face the direction of the coordinate specified
 * by the return values of the two child nodes
 *
 * @author Mariusz Derezinski-Choo
 */
public class TowardsNode extends MultiOperandMultiOperationNode<RotateExecutable> {
    private static final double RADIANS_TO_DEGREES = 180 / Math.PI;

    public TowardsNode(String text) {
        super(text);
    }

    @Override
    protected void validateArguments() {
        if(arguments.size() < 2){
            throw new InsufficientArgumentException(toString());
        }
    }

    @Override
    protected double singleExecution(TurtleContext context, RotateExecutable executable) {
        Iterator<ParserNode> iterator = arguments.iterator();
        double endX = iterator.next().execute(context);
        double endY = iterator.next().execute(context);
        while(iterator.hasNext()){
            endX = endY;
            endY = iterator.next().execute(context);
        }
        double id = context.getWorkingID();
        TurtleData td = context.getData().turtleData(id);
        double xTowards = endX - td.getX();
        double yTowards = endY - td.getY();
        //FIXME: bounds on arctan!
        double degrees = Math.atan(xTowards/yTowards);
        double startHeading = td.getHeading();
        td.setHeading(degrees * RADIANS_TO_DEGREES);
        double endHeading = td.getHeading();
        executable.addMove((int)id, startHeading, endHeading);
        return endHeading - startHeading;
    }

    @Override
    protected RotateExecutable fetchExecutable() {
        return new RotateExecutable();
    }
}
