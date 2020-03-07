package parserModel.nodes.leafNodes.multiExecution;

import parserModel.TurtleContext;
import parserModel.nodes.leafNodes.LeafNode;

import java.util.List;

/**
 * A node that when executed, sets the pen down
 * in the visualizer so that the turtle will draw if moved
 *
 * @author Mariusz Derezinski-Choo
 */
public class PenDownNode extends LeafNode {
    private static final double SUCCESS = 1.0;

    /**
     * Construct a PenDown Node
     * @param text the user input associated with this call
     */
    public PenDownNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        List<Double> activeTurtles = context.getActiveTurtles();
        for(double d : activeTurtles){
            context.setWorkingTurtle(d);
            context.getWorkingTurtle().penDown();
        }
        context.replaceActiveTurtles(activeTurtles);
        return SUCCESS;
    }
}
