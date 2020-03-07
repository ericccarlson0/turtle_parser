package parserModel.nodes.parentNodes.unaryOperationNode.allExecution;

import execution.Executable;
import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.parentNodes.ParentNode;
import java.util.List;

/**
 * An abstract class that represents a ParentNode that only takes on child, but whose
 * child must be executed across the range of all turtles that exist
 * @param <T> the executable that must be fetched (is generic to reflect template method design pattern)
 */
public abstract class UnaryOperatorAllExecutionNode<T extends Executable> extends ParentNode {

    /**
     * Construct a UnaryOperatorAllExecutionNode
     * @param text the user-inputted text associated with this construction
     */
    public UnaryOperatorAllExecutionNode(String text) {
        super(1, text);
    }

    @Override
    protected void validateArguments(){
        if(arguments.size() < myMinArguments){
            throw new InsufficientArgumentException(toString());
        }
    }

    @Override
    protected double runValidated(TurtleContext context) {
        double ret = 0.0;
        List<Double> ids = context.getActiveTurtles();
        T executable = fetchExecutable();
        for(double id : context.getData().getAllTurtles()){
            context.setWorkingTurtle(id);
            ret = singleExecution(context,executable);
        }
        context.addToQueue(executable);
        context.replaceActiveTurtles(ids);
        return ret;
    }

    /**
     * Execute a single instance of this command, meaning for one turtle
     * @param context the context to fetch data from
     * @param executable the executable to be added to
     * @return the value of the execution
     */
    protected abstract double singleExecution(TurtleContext context, T executable);

    /**
     * Fetch the specific type of executable needed in the concrete subclass
     * @return the Executable that will be added to and eventually added to the executableQueue
     */
    protected abstract T fetchExecutable();
}
