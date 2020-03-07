package parserModel.nodes.leafNodes.multiExecution;

import execution.HideExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.leafNodes.LeafNode;

import java.util.List;

/**
 * A node that when executed, Shows the Turtle on the Screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class ShowNode extends LeafNode {
    private static final double SUCCESS = 1.0;

    /**
     * Construct a Show Node
     * @param text the user-inputted text associated with this call to ShowNode
     */
    public ShowNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> activeTurtles = context.getActiveTurtles();
        HideExecutable executable = new HideExecutable();
        for(double id : activeTurtles){
            context.setWorkingTurtle(id);
            context.getWorkingTurtle().show();
            executable.addMove((int)id, false);
        }
        context.addToQueue(executable);
        context.replaceActiveTurtles(activeTurtles);
        return SUCCESS;
    }
}
