package parserModel.nodes.turtleNodes;

import execution.RTurnExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
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

    public RTurnNode(){}

    @Override
    public void addNode(ParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute(VisualContext context) {
        double degrees = myRotationNode.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        td.turnClockwise(degrees);
        context.getExecutableQueue().add(new RTurnExecutable(degrees));
        return degrees;
    }

    @Override
    public boolean isComplete() {
        return myRotationNode != null;
    }
}
