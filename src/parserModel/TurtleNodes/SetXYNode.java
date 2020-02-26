package parserModel.TurtleNodes;

import executables.Executable;
import executables.SetXYExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

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
        double xPos = myXNode.execute(context);
        double yPos = myYNode.execute(context);
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
