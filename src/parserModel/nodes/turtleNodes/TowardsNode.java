package parserModel.nodes.turtleNodes;

import execution.SetHeadingExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;

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
        context.getExecutableQueue().add(new SetHeadingExecutable(degrees));
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
