package parserModel.nodes.display;

import execution.SetPenColorExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.UnaryOperationNode;

import java.util.List;

public class SetPenColorNode extends UnaryOperationNode {

    @Override
    public double execute(TurtleContext context) {
        List<Double> previousActives = context.getActiveTurtles();
        context.clearActiveTurtles();
        for(double id : context.getData().getAllTurtles()) {
            double newPenColor = myArgumentNode.execute(context);
            context.addToQueue(new SetPenColorExecutable(newPenColor));
        }
        return newPenColor;
    }
}
