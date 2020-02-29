package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * to face the direction of the coordinate specified
 * by the return values of the two child nodes
 *
 * @author Mariusz Derezinski-Choo
 */
public class TowardsNode extends CommandParserNode {
    private static final double SUCCESS = 0.0;

    private ParserNode myXNode;
    private ParserNode myYNode;

    public TowardsNode(){
        super();
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
        double xInput = myXNode.execute(context);
        double yInput = myYNode.execute(context);
        double xTowards = xInput - td.getX();
        double yTowards = yInput - td.getY();
        double degrees = Math.atan(xTowards/yTowards);

        double startHeading = td.getHeading();
        td.setHeading(degrees);
        double endHeading = td.getHeading();
        context.getExecutableQueue().add(new RotateExecutable(startHeading, endHeading));
        return SUCCESS;
    }

    @Override
    public boolean isComplete() {
        return myYNode != null;
    }
}
