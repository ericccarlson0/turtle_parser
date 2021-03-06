package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import execution.RotateExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;

/**
 * An abstract class that implements the Template Method design pattern for the generic
 * action of turning the turtle
 */
public abstract class TurnNode extends UnaryOperationMultiExecutionNode<RotateExecutable> {

    /**
     * Construct a TurnNode
     * @param text the user-inputted text associated with this construction
     */
    public TurnNode(String text) {
        super(text);
    }

    @Override
    protected double singleExecution(TurtleContext context, RotateExecutable executable){
        double id = context.getWorkingID();
        TurtleData td = context.getData().turtleData(id);

        double startHeading = td.getHeading();
        for(ParserNode node : arguments) {
            turn(td, node.execute(context));
        }
        double endHeading = td.getHeading();
        //TODO: throw exception
        executable.addMove((int)id, startHeading, endHeading);

        return endHeading - startHeading;
    }

    @Override
    protected RotateExecutable fetchExecutable(){
        return new RotateExecutable();
    }

    /**
     * turn the turtle in whichever way necessary
     * @param td the turtle to turn
     * @param degrees the degrees parameter that the turtle will be turned by in some fassion
     */
    protected abstract void turn(TurtleData td, double degrees);
}