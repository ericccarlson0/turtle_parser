package parserModel.nodes.turtleNodes;

import execution.MoveExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
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
    public double execute(TurtleContext context) {
        double distance = myLength.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        double startX = td.getX();
        double startY = td.getY();
        td.backward(distance);
        double endX = td.getX();
        double endY = td.getY();
        context.getExecutableQueue().add(new MoveExecutable(startX, startY, endX, endY));
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
