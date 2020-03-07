package parserModel.nodes.parentNodes.unaryOperationNode.allExecution;

import execution.newExecutables.SetShapeExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.parentNodes.ParentNode;

import javax.swing.text.html.parser.Parser;

public class SetShapeNode extends UnaryOperatorAllExecutionNode<SetShapeExecutable> {
    public SetShapeNode(String text) {
        super(text);
    }

    @Override
    protected double singleExecution(TurtleContext context, SetShapeExecutable executable) {
        double shapeIndex = 0;
        for(ParserNode node : arguments){
            shapeIndex = node.execute(context);
        }
        executable.addMove((int)context.getWorkingID(), (int)shapeIndex);
        return shapeIndex;
    }

    @Override
    protected SetShapeExecutable fetchExecutable() {
        return new SetShapeExecutable();
    }
}
