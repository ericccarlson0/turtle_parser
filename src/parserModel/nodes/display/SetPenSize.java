package parserModel.nodes.display;

import execution.newExecutables.PenSizeExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.UnaryOperationNode;

public class SetPenSize extends UnaryOperationNode {
    @Override
    public double execute(TurtleContext context) {
        double penSize = myArgumentNode.execute(context);
        context.getExecutableQueue().add(new PenSizeExecutable(penSize));
        return penSize;
    }
}
