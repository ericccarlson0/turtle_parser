package parserModel.nodes.leafNodes.multiExecution;

import execution.HideExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.leafNodes.LeafNode;

import java.util.List;

/**
 * A node that when executed, Hides the turtle from
 * the screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class HideNode extends LeafNode {
    private static final double SUCCESS = 0.0;

    public HideNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> activeTurtles = context.getActiveTurtles();
        HideExecutable executable = new HideExecutable();
        for(double id : activeTurtles){
            context.setWorkingTurtle(id);
            context.getWorkingTurtle().hide();
            executable.addMove((int)id, true);
        }
        context.addToQueue(executable);
        context.replaceActiveTurtles(activeTurtles);
        return SUCCESS;
    }
}
