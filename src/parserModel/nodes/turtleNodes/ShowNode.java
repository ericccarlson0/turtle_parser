package parserModel.nodes.turtleNodes;

import execution.HideExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

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
    public double execute(TurtleContext context) {
        HideExecutable hideExecutable = new HideExecutable();
        for(double id : context.getActiveTurtles()){
            TurtleData td = context.getData().turtleData(id);
            td.hide();
            hideExecutable.addMove((int)id, false);
        }
        hideExecutable.setName(commandNameResource.getString("ShowTurtle"));

        context.addToQueue(hideExecutable);
        return 0;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
