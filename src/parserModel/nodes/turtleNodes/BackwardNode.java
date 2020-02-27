package parserModel.nodes.turtleNodes;

import execution.BackwardExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

/**
 * A node that when executed, moves the turtle backward
 * the value of its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class BackwardNode extends CommandParserNode {
    private ParserNode myLength;

    /**
     * Construct a BackwardNode
     */
    public BackwardNode(){
        super();
    }

    @Override
    public double execute(VisualContext context) {
        double distance = myLength.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        td.backward(distance);
        context.getExecutableQueue().add(new BackwardExecutable(distance));
        return distance;
    }

    @Override
    public boolean isComplete() {
        return myLength != null;
    }

    @Override
    public void addNode(ParserNode node) {
        myLength = node;
    }
}
