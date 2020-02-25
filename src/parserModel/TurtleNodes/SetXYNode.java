package parserModel.TurtleNodes;

import executables.Executable;
import executables.SetXYExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;

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
        double xPos = myXNode.execute();
        double yPos = myYNode.execute();
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
