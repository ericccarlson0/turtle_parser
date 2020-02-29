package parserModel.nodes.turtleNodes;

import execution.RotateExecutable;
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
    private ParserNode myDegrees;

    public SetHeadingNode(){
        super();
        myDegrees = null;
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
        double startHeading = td.getHeading();
        td.setHeading(degrees);
        double endHeading = td.getHeading();
        context.getExecutableQueue().add(new RotateExecutable(startHeading, endHeading));
        return degrees;
    }

    @Override
    public boolean isComplete() {
        return myDegrees != null;
    }
}
