package parserModel.nodes.turtleNodes;

import execution.SetXYExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
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
    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        double xPos = myXNode.execute(context);
        double yPos = myYNode.execute(context);
        td.setX(xPos);
        td.setY(yPos);
        context.getExecutableQueue().add(new SetXYExecutable(xPos, yPos));
        return xPos;
    }

    @Override
    public boolean isComplete() {
        return myYNode != null;
    }
}
