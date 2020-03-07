package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;

/**
 * A node that, when executed, moves the turtle forward.
 *
 * @author Mariusz Derezinski-Choo
 */
public class ForwardNode extends UnaryOperationMultiExecutionNode<MoveExecutable> {
    /**
     * Construct a ForwardNode
     * @param text the user-inputted text associated with this construction
     */
    public ForwardNode(String text){
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
        td.forward(distance);
        double endX = td.getX();
        double endY = td.getY();
        //TODO: throw exception
        executable.addMove((int)id, startX, startY, endX, endY,context.getData().turtleData(id).getPenDown());
        return distance;
    }

    @Override
    protected MoveExecutable fetchExecutable() {
        return new MoveExecutable();
    }
}
