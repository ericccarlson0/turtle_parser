package parserModel.nodes.parentNodes.unaryOperationNode;

import execution.MoveExecutable;
import execution.newExecutables.SetBackgroundExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.parentNodes.ParentNode;
import parserModel.nodes.parentNodes.unaryOperationNode.multipleExecution.UnaryOperationMultiExecutionNode;

public class SetBackgroundNode extends UnaryOperationNode {

    public SetBackgroundNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        SetBackgroundExecutable executable = new SetBackgroundExecutable();
        double id = context.getWorkingID();
        double background = node.execute(context);
        TurtleData td = context.getData().turtleData(id);
        //TODO: set background in model!
        executable.addMove((int) background);
        context.addToQueue(executable);
        return background;
    }
}
