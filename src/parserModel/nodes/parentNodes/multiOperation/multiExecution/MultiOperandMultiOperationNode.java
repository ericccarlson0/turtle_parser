package parserModel.nodes.parentNodes.multiOperation.multiExecution;

import execution.Executable;
import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.parentNodes.ParentNode;

import java.util.List;

public abstract class MultiOperandMultiOperationNode<T extends Executable> extends ParentNode {

    protected MultiOperandMultiOperationNode(String text) {
        super(2, text);
    }

    @Override
    protected double runValidated(TurtleContext context) {
        double ret = 0.0;
        List<Double> ids = context.getActiveTurtles();
        T executable = fetchExecutable();
        for (double id : ids) {
            context.setWorkingTurtle(id);
            ret = singleExecution(context, executable);
        }
        context.addToQueue(executable);
        context.replaceActiveTurtles(ids);
        return ret;
    }


    protected abstract double singleExecution(TurtleContext context, T executable);

    protected abstract T fetchExecutable();
}