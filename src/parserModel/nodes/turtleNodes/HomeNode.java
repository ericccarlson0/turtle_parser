package parserModel.nodes.turtleNodes;

import execution.HomeExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

/**
 * A node that when executed, moves the turtle back to the
 * center of the screen (0, 0)
 *
 * @author Mariusz Derezinski-Choo
 */
public class HomeNode extends CommandParserNode {
    private static final double SUCCESS = 0.0;

    public HomeNode() {
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.home();
        context.getExecutableQueue().add(new HomeExecutable());
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
