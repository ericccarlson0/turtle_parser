package parserModel.nodes.turtleNodes;

import execution.SetXYExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

public class SetXYNode extends CommandParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;

    public SetXYNode() {
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
        double xPos = myXNode.execute(context);
        double yPos = myYNode.execute(context);
        td.setX(xPos);
        td.setY(yPos);
        context.getExecutableQueue().add(new SetXYExecutable(xPos, yPos));
        return xPos; // TODO (is this return correct?)
    }

    public boolean isComplete() {
        return myYNode != null;
    }

    @Override
    public String toString(){
        return "SETXY: " + myXNode + " " + myYNode;
    }
}
