package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;

/**
 * A node that, when executed, moves the turtle backward.
 *
 * @author Mariusz Derezinski-Choo
 */
public class BackwardNode extends UnaryOperationMultiExecutionNode<MoveExecutable> {

    /**
     * Construct a Backward Node
     * @param text the user-inputted text associated with this construction
     */
    public BackwardNode(String text){
        super(text);
    }

    @Override
    protected double singleExecution(TurtleContext context, MoveExecutable executable){
        double id = context.getWorkingID();
        double distance = 0;
        for (ParserNode node : arguments) {
            distance += node.execute(context);
        }
        TurtleData td = context.getData().turtleData(id);
        double startX = td.getX();
        double startY = td.getY();
        td.backward(distance);
        double endX = td.getX();
        double endY = td.getY();
        //TODO: throw exception
        executable.addMove((int)id, startX, startY, endX, endY);
        return distance;
    }

    @Override
    protected MoveExecutable fetchExecutable() {
        return new MoveExecutable();
    }
}
