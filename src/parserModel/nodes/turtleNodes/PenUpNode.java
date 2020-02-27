package parserModel.nodes.turtleNodes;

import execution.PenUpExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

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
    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.penUp();
        context.getExecutableQueue().add(new PenUpExecutable());
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
