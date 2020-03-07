package parserModel.nodes.leafNodes;

import execution.HideExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;

/**
 * A node that when executed, Hides the turtle from
 * the screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class HideNode extends LeafNode{
    private static final double SUCCESS = 0.0;


    public double singleExecution(TurtleContext context, HideExecutable executable) {
        double id = context.getWorkingID();
        TurtleData td = context.getData().turtleData(id);
        td.hide();
        executable.addMove((int)id, true);
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
