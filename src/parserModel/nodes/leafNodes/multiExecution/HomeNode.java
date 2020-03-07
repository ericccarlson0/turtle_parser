package parserModel.nodes.leafNodes.multiExecution;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.leafNodes.LeafNode;

/**
 * A node that when executed, moves the turtle back to the
 * center of the screen (0, 0)
 *
 * @author Mariusz Derezinski-Choo
 */
public class HomeNode extends LeafNode {
    private static final String NAME = "Home";
    private static final double SUCCESS = 0.0;

    /**
     * Construct a HomeNode object
     * @param text the text input associated with this HomeNode call
     */
    public HomeNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        MoveExecutable moveExecutable = new MoveExecutable(NAME);
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.clear();
            moveExecutable.addMove((int)id, startX, startY, 0, 0,context.getData().turtleData(id).getPenDown());
        }
        context.addToQueue(moveExecutable);
        return SUCCESS;

    }
}
