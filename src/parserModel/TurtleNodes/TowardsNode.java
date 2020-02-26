package parserModel.TurtleNodes;

import executables.Executable;
import executables.HeadingExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;

import visualizer.VisualContext;

import parserModel.TurtleData;


public class TowardsNode extends CommandParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;

    public TowardsNode() {
    }

    public void addNode(ParserNode node) {
        if (myXNode == null) {
            myXNode = node;
        } else if (myYNode == null) {
            myYNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        double xTowards = myXNode.execute(context) - td.getX();
        double yTowards = myYNode.execute(context) - td.getY();
        double degrees = Math.atan(xTowards/yTowards);
        td.setHeading(degrees);
        context.getExecutableQueue().add(new HeadingExecutable(degrees));
        return 0.0; // TODO (is this return correct?)
    }

    public boolean isComplete() {
        return myYNode != null;
    }

    @Override
    public String toString(){
        return "TOWARDS: " + myXNode + " " + myYNode;
    }
}
