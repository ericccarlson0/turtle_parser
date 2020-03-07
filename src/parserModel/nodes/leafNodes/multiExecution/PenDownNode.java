package parserModel.nodes.display;

import execution.PenDownExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.VariableNode;

/**
 * A node that when executed, sets the pen down
 * in the visualizer so that the turtle will draw if moved
 *
 * @author Mariusz Derezinski-Choo
 */
public class PenDownNode implements ParserNode {

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void addVariable(VariableNode node) {

    }

    @Override
    public double execute(TurtleContext context) {
        PenDownExecutable penDownExecutable = new PenDownExecutable();
        for(double id : context.getActiveTurtles()) {
            TurtleData td = context.getData().turtleData(id);
            td.penUp();
            penDownExecutable.addMove((int)id, true);
        }
        context.addToQueue(penDownExecutable);
        return 0.0;
    }

    public boolean isComplete() {
        return true;
    }
}
