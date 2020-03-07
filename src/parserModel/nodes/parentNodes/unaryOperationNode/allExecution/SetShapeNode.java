package parserModel.nodes.parentNodes.unaryOperationNode.allExecution;

import execution.newExecutables.SetShapeExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;

/**
 * A Node that sets the Shape index for all turtles
 *
 * @author Mariusz Derezinski-Choo
 */
public class SetShapeNode extends UnaryOperatorAllExecutionNode<SetShapeExecutable> {

    /**
     * Construct a SetShapeIndex object
     * @param text the user-jnputted text associated with this construction
     */
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
