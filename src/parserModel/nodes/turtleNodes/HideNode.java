package parserModel.nodes.turtleNodes;

import execution.HideExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.TurtleData;

import java.util.List;

/**
 * A node that when executed, Hides the turtle from
 * the screen
 *
 * @author Mariusz Derezinski-Choo
 */
public class HideNode extends CommandParserNode {

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        HideExecutable hideExecutable = new HideExecutable();
        for(double id : context.getActiveTurtles()){
            TurtleData td = context.getData().turtleData(id);
            td.hide();
            hideExecutable.addMove((int)id, true);
        }
        context.addToQueue(hideExecutable);
        return 0;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

}
