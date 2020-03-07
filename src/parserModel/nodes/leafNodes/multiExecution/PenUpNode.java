package parserModel.nodes.leafNodes.multiExecution;

import parserModel.TurtleContext;
import parserModel.nodes.leafNodes.LeafNode;

import java.util.List;

/**
 * A node that when executed, sets the pen up
 * in the visualizer so that the turtle will not draw if moved
 *
 * @author Mariusz Derezinski-Choo
 */
public class PenUpNode extends LeafNode {
    private static final double SUCCESS = 0.0;

    /**
     * Construct a Pen Up Node
     * @param text the user inputted text associated with this call of Pen Up
     */
    public PenUpNode(String text) {
        super(text);
    }

    public double execute(TurtleContext context) {
        List<Double> activeTurtles = context.getActiveTurtles();
        for(double d : activeTurtles){
            context.setWorkingTurtle(d);
            context.getWorkingTurtle().penUp();
        }
        context.replaceActiveTurtles(activeTurtles);
        return SUCCESS;
    }
}
