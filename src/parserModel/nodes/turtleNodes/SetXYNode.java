package parserModel.nodes.turtleNodes;

import execution.MoveExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.TurtleData;

/**
 * A node that when executed, Sets the X and
 * Y coordinates of the turtle to the values
 * returned by the child nodes
 *
 * @author Mariusz Derezinski-Choo
 */
public class SetXYNode extends CommandParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;

    public SetXYNode(){
        super();
        myXNode = null;
        myYNode = null;
    }

    @Override
    public void addNode(ParserNode node) {
        if (myXNode == null) {
            myXNode = node;
        } else if (myYNode == null) {
            myYNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute(TurtleContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        double startX = td.getX();
        double startY = td.getY();
        double endX = myXNode.execute(context);
        double endY = myYNode.execute(context);
        td.setX(endX);
        td.setY(endY);
        context.getExecutableQueue().add(new MoveExecutable(startX, startY, endX, endY));
        return endX; //?
    }

    @Override
    public boolean isComplete() {
        return myYNode != null;
    }
}
