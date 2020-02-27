package parserModel.nodes.turtleNodes;

import execution.ClearExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
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
        context.getExecutableQueue().add(new ClearExecutable());
        return SUCCESS;

    }

    @Override
    public boolean isComplete() {
        return true;
    }

}
