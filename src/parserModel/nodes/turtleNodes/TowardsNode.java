package parserModel.nodes.turtleNodes;

import execution.SetHeadingExecutable;
import execution.TowardsExecutable;
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
        double xInput = myXNode.execute(context);
        double yInput = myYNode.execute(context);
        double xTowards = xInput - td.getX();
        double yTowards = yInput - td.getY();
        double degrees = Math.atan(xTowards/yTowards);
        td.setHeading(degrees); //TODO check this TOWARDS
        context.getExecutableQueue().add(new TowardsExecutable(xInput,yInput));
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
