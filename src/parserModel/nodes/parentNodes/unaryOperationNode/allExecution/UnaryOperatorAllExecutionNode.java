package parserModel.nodes.parentNodes.unaryOperationNode.allExecution;

import execution.Executable;
import parserModel.TurtleContext;
import parserModel.exceptions.InsufficientArgumentException;
import parserModel.nodes.parentNodes.ParentNode;
import parserModel.nodes.parentNodes.unaryOperationNode.UnaryOperationNode;

import java.util.List;

public abstract class UnaryOperatorAllExecutionNode<T extends Executable> extends ParentNode {

    public UnaryOperatorAllExecutionNode(String text) {
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
        T executable = fetchExecutable();
        for(double id : context.getData().getAllTurtles()){
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
