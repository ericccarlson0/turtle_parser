package parserModel.nodes.turtleNodes;

import execution.ClearExecutable;
import parserModel.GlobalData;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.Turtle;
import visualizer.VisualContext;

/**
 * A node that when executed, clears the
 * turtle screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class ClearNode extends CommandParserNode {
    private static final double SUCCESS = 0.0;

    @Override
    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    @Override
    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        double startX = td.getX();
        double startY = td.getY();
        td.clear();
        context.getExecutableQueue().add(new ClearExecutable(startX, startY));
        return SUCCESS;

    }

    @Override
    public boolean isComplete() {
        return true;
    }

}
