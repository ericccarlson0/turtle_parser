package parserModel.nodes.display;

import execution.ClearExecutable;
import execution.MoveExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.VariableNode;

/**
 * A node that when executed, clears the
 * turtle screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class ClearNode implements ParserNode {
    private static final double SUCCESS = 0.0;

    @Override
    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    @Override
    public void addVariable(VariableNode node) {

    }

    @Override
    public double execute(TurtleContext context) {
        MoveExecutable moveExecutable = new MoveExecutable();
        ClearExecutable clearExecutable = new ClearExecutable();
        for(double id : context.getData().getAllTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            double startX = td.getX();
            double startY = td.getY();
            td.clear();
            moveExecutable.addMove((int) id, startX, startY, 0, 0);
            clearExecutable.addMove((int) id);
        }
        context.addToQueue(moveExecutable);
        context.addToQueue(clearExecutable);
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

}
