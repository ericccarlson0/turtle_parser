package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * left the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class LTurnNode extends CommandParserNode {
    private ParserNode myRotationNode;

    public LTurnNode(){
        super();
        myRotationNode = null;
    }

    @Override
    public void addNode(ParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute(TurtleContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        double degrees = myRotationNode.execute(context);
        double startHeading = td.getHeading();
        td.turnCounterClockwise(degrees);
        double endHeding = td.getHeading();
        context.getExecutableQueue().add(new RotateExecutable(startHeading, endHeding));
        return degrees;
    }

    public boolean isComplete() {
        return myRotationNode != null;
    }
}
