package parserModel.nodes.turtleNodes;

import execution.SetHeadingExecutable;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.CommandParserNode;
import parserModel.TurtleData;
import visualizer.VisualContext;

/**
 * A node that when executed, rotates the turtle
 * so that it faces the direction of the heading,
 * determined by its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class SetHeadingNode extends CommandParserNode {
    public ParserNode myDegrees;

    public SetHeadingNode() {
    }

    @Override
    public void addNode(ParserNode node) {
        if (myDegrees == null) {
            myDegrees = node;
        }
    }

    @Override
    public double execute(VisualContext context) {
        double degrees = myDegrees.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        td.setHeading(degrees);
        context.getExecutableQueue().add(new SetHeadingExecutable(degrees));
        return degrees;
    }

    @Override
    public boolean isComplete() {
        return myDegrees != null;
    }
}
