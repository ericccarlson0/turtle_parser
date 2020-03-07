package parserModel.nodes.turtleNodes;

import execution.PenDownExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

/**
 * A node that when executed, sets the pen up
 * in the visualizer so that the turtle will not draw if moved
 *
 * @author Mariusz Derezinski-Choo
 */
public class PenUpNode extends CommandParserNode {
    private static final double SUCCESS = 0.0;

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        PenDownExecutable penDownExecutable = new PenDownExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            td.penUp();
            penDownExecutable.addMove((int)id, false);
        }
        penDownExecutable.setName("PenUp");

        context.addToQueue(penDownExecutable);
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
