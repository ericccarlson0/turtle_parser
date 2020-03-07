package parserModel.nodes.display;

import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.VariableNode;

/**
 * A node that when executed, moves the turtle back to the
 * center of the screen (0, 0)
 *
 * @author Mariusz Derezinski-Choo
 */
public class HomeNode implements ParserNode {
    private static final double SUCCESS = 0.0;

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addVariable(VariableNode node) {

    }

    @Override
    public double execute(TurtleContext context) {
        MoveExecutable moveExecutable = new MoveExecutable();
        for(double id : context.getData().getAllTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.clear();
            moveExecutable.addMove((int)id, startX, startY, 0, 0);
        }
        context.addToQueue(moveExecutable);
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
