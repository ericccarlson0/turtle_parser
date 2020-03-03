package parserModel.nodes.display;

import execution.newExecutables.SetPenColorExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.UnaryOperationNode;

public class SetPenColorNode extends UnaryOperationNode {

    @Override
    public double execute(TurtleContext context) {
        double newPenColor = myArgumentNode.execute(context);
        //context.getExecutableQueue().add(new SetPenColorExecutable(newPenColor)); //FIXME!
        return newPenColor;
    }
}
