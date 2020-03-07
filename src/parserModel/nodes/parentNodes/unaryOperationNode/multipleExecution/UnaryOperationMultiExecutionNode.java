package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import execution.Executable;
import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.parentNodes.ParentNode;

import java.util.List;

public abstract class UnaryOperationMultiExecutionNode<T extends Executable> extends ParentNode {
    public UnaryOperationMultiExecutionNode(String text) {
        super(1, text);
    }

    @Override
    protected void validateArguments(){
        if(arguments.size() < myMinArguments){
            throw new InsufficientArgumentException();
        }
    }

    @Override
    protected double runValidated(TurtleContext context) {
        double ret = 0.0;
        List<Double> ids = context.getActiveTurtles();
        System.out.println("the active ids are: " + ids);
        T executable = fetchExecutable();
        for(double id : ids){
            context.setWorkingTurtle(id);
            ret = singleExecution(context,executable);
        }
        context.addToQueue(executable);
        context.replaceActiveTurtles(ids);
        return ret;
    }


    protected abstract double singleExecution(TurtleContext context, T executable);

    protected abstract T fetchExecutable();
}
