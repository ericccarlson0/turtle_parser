package parserModel.nodes.turtleNodes;

import execution.PenDownExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.TurtleData;

import java.util.ArrayList;
import java.util.List;

/**
 * A node that when executed, sets the pen down
 * in the visualizer so that the turtle will draw if moved
 *
 * @author Mariusz Derezinski-Choo
 */
public class PenDownNode extends CommandParserNode {

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
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
