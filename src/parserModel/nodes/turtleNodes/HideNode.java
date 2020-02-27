package parserModel.nodes.turtleNodes;

import execution.HideExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

/**
 * A node that when executed, Hides the turtle from
 * the screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class HideNode extends CommandParserNode {

    public HideNode() {
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.hide();
        context.getExecutableQueue().add(new HideExecutable());
        return 0;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

}
