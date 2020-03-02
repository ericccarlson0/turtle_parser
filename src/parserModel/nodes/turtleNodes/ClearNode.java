package parserModel.nodes.turtleNodes;

import execution.ClearExecutable;
import execution.MoveExecutable;
import parserModel.GlobalData;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

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
    public double execute(TurtleContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        double startX = td.getX();
        double startY = td.getY();
        td.clear();
        context.getExecutableQueue().add(new MoveExecutable(startX, startY, 0, 0)); //FIXME: clear screen doesnt work on
        context.getExecutableQueue().add(new ClearExecutable(startX, startY));
        return SUCCESS;

    }

    @Override
    public boolean isComplete() {
        return true;
    }

}
