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
        SetPenColorExecutable executable = new SetPenColorExecutable();
        double newPenColor = 0;
        for(double id : context.getData().getAllTurtles()) {
            newPenColor = myArgumentNode.execute(context);
            executable.addMove((int)(id), (int)newPenColor);
        }
        return newPenColor;
    }
}
