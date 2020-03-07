package parserModel.nodes.leafNodes.multiExecution;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.LeafNode;
import parserModel.nodes.leafNodes.VariableNode;

/**
 * A node that when executed, moves the turtle back to the
 * center of the screen (0, 0)
 *
 * @author Mariusz Derezinski-Choo
 */
public class HomeNode extends LeafNode {
    private static final double SUCCESS = 0.0;

    public HomeNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        MoveExecutable moveExecutable = new MoveExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.clear();
            moveExecutable.addMove((int)id, startX, startY, 0, 0);
        }
        moveExecutable.setName("Home");
        context.addToQueue(moveExecutable);
        return SUCCESS;

    }
}
