package parserModel.nodes.parentNodes.unaryOperationNode.allExecution;

import execution.SetPenColorExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.parentNodes.ParentNode;

import java.util.List;

public class SetPenColorNode extends UnaryOperatorAllExecutionNode<SetPenColorExecutable> {

    public SetPenColorNode(String text) {
        super(text);
    }

    @Override
    protected double singleExecution(TurtleContext context, SetPenColorExecutable executable) {
        double penIndex = 0;
        for(ParserNode node : arguments){
            penIndex = node.execute(context);
        }
        executable.addMove((int)context.getWorkingID(), (int)penIndex);
        return penIndex;
    }

    @Override
    protected SetPenColorExecutable fetchExecutable() {
        return new SetPenColorExecutable();
    }
}
