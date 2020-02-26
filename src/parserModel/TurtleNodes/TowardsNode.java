package parserModel.TurtleNodes;

import executables.Executable;
import executables.TowardsExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

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
        double xTowards = myXNode.execute(context);
        double yTowards = myYNode.execute(context);
        context.getExecutableQueue().add(new TowardsExecutable(xTowards, yTowards));
        return xTowards; // TODO (is this return correct?)
    }

    public boolean isComplete() {
        return myYNode != null;
    }

    @Override
    public String toString(){
        return "TOWARDS: " + myXNode + " " + myYNode;
    }
}
