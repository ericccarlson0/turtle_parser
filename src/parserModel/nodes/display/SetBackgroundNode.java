package parserModel.nodes.display;

import execution.newExecutables.SetBackgroundExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.UnaryOperationNode;

public class SetBackgroundNode extends UnaryOperationNode {
    @Override
    public double execute(TurtleContext context) {
        double backgroundIndex = myArgumentNode.execute(context);
        context.addToQueue(new SetBackgroundExecutable((int)backgroundIndex));
        return backgroundIndex;
    }
}
