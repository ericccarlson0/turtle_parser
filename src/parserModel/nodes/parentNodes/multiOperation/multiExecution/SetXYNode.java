package parserModel.nodes.parentNodes.multiOperation.multiExecution;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

/**
 * A node that when executed, Sets the X and
 * Y coordinates of the turtle to the values
 * returned by the child nodes
 *
 * @author Mariusz Derezinski-Choo
 */
public class SetXYNode extends MultiOperandMultiOperationNode<MoveExecutable> {

    public SetXYNode(String text) {
        super(text);
    }

    @Override
    protected void validateArguments() {
        if(arguments.size() < 2){
            throw new InsufficientArgumentException();
        }
    }

    @Override
    protected double singleExecution(TurtleContext context, MoveExecutable executable) {
        Iterator<ParserNode> iterator = arguments.iterator();
        double endX = iterator.next().execute(context);
        double endY = iterator.next().execute(context);
        while(iterator.hasNext()){
            endX = endY;
            endY = iterator.next().execute(context);
        }
        double id = context.getWorkingID();
        TurtleData td = context.getData().turtleData(id);
        double startX = td.getX();
        double startY = td.getY();
        td.setX(endX);
        td.setY(endY);
        executable.addMove((int)id, startX, startY, endX, endY);
        return endX; //FIXME?
    }

    @Override
    protected MoveExecutable fetchExecutable() {
        return new MoveExecutable();
    }
}
