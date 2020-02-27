package parserModel.nodes.turtleNodes;

import execution.ShowExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

/**
 * A node that when executed, Shows the Turtle on the Screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class ShowNode extends CommandParserNode {

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.show();
        context.getExecutableQueue().add(new ShowExecutable());
        return 0;

    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
