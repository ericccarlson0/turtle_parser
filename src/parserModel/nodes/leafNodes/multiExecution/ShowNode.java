package parserModel.nodes.leafNodes;

import execution.HideExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;

/**
 * A node that when executed, Shows the Turtle on the Screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class ShowNode extends LeafNode implements ParserNode {
    private static final double SUCCESS = 1.0;

    public double singleExecution(TurtleContext context, HideExecutable executable) {
        double id = context.getWorkingID();
        TurtleData td = context.getData().turtleData(id);
        td.hide();
        executable.addMove((int)id, false);
        return SUCCESS;
    }

    public HideExecutable fetchExecutable() {
        return new HideExecutable();
    }

    @Override
    public double execute(TurtleContext context) {
        return 0;
    }
}
