package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;
import parserModel.TurtleData;

/**
 * A node that when executed, rotates the turtle
 * right the number of degrees returned
 * by its child node
 *
 * @author Mariusz Derezinski-Choo
 */
public class RTurnNode extends CommandParserNode {
    private ParserNode myRotationNode;

    public RTurnNode(){
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
        double degrees = myRotationNode.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        double startHeading = td.getHeading();
        td.turnClockwise(degrees);
        double endHeading = td.getHeading();
        context.getExecutableQueue().add(new RotateExecutable(startHeading, endHeading));
        return degrees;
    }

    @Override
    public boolean isComplete() {
        return myRotationNode != null;
    }
}
