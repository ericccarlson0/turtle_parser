package parserModel.TurtleNodes;

import execution.Executable;
import execution.SetXYExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class SetXYNode extends CommandParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;
    private List<Executable> executableQueue;

    public SetXYNode(List<Executable> queue) {
        executableQueue = queue;
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

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        double xPos = myXNode.execute();
        double yPos = myYNode.execute();
        td.setX(xPos);
        td.setY(yPos);
        executableQueue.add(new SetXYExecutable(xPos, yPos));
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
