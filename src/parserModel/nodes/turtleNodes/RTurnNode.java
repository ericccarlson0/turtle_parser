package parserModel.nodes.turtleNodes;

import execution.RTurnExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

public class RTurnNode extends CommandParserNode {
    private ParserNode myRotationNode;

    public RTurnNode(){}

    public void addNode(ParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public double execute(VisualContext context) {
        double degrees = myRotationNode.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        td.turnClockwise(degrees);
        context.getExecutableQueue().add(new RTurnExecutable(degrees));
        return degrees;
    }

    public boolean isComplete() {
        return myRotationNode != null;
    }

    @Override
    public String toString(){
        return "RT: " + myRotationNode;
    }
}
