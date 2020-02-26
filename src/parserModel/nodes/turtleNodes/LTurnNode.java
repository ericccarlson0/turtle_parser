package parserModel.nodes.turtleNodes;

import execution.LTurnExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;


public class LTurnNode extends CommandParserNode {
    private ParserNode myRotationNode;

    public LTurnNode() {

    }

    public void addNode(ParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

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

    @Override
    public String toString(){
        return "LT: " + myRotationNode;
    }
}
