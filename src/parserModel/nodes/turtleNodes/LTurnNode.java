package parserModel.nodes.turtleNodes;

import execution.LTurnExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
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
    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        double degrees = myRotationNode.execute(context);
        td.turnCounterClockwise(degrees);
        context.getExecutableQueue().add(new LTurnExecutable(degrees));
        return degrees;
    }

    public boolean isComplete() {
        return myRotationNode != null;
    }
}
