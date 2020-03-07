package parserModel.nodes.parentNodes.unaryOperationNode;

import execution.SetBackgroundExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;

public class SetBackgroundNode extends UnaryOperationNode {

    /**
     * Construct a SetBackgroundNode
     * @param text the user-inputted text associated with this construction
     */
    public SetBackgroundNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        SetBackgroundExecutable executable = new SetBackgroundExecutable();
        double background = node.execute(context);
        executable.addMove((int) background);
        context.addToQueue(executable);
        return background;
    }
}
