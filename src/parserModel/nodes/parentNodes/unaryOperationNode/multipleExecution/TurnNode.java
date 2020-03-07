package parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution;

import execution.RotateExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;

public abstract class TurnNode extends UnaryOperationMultiExecutionNode<RotateExecutable> {

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

    protected abstract void turn(TurtleData td, double degrees);
}