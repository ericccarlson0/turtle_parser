package parserModel.TurtleNodes;

import executables.BackwardExecutable;
import executables.Executable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class BackwardNode extends CommandParserNode {
    private ParserNode myLength;

    public BackwardNode(){
        super();
    }

    public double execute(VisualContext context) {
        double distance = myLength.execute(context);
        context.getExecutableQueue().add(new BackwardExecutable(distance));
        return distance;
    }

    public boolean isComplete() {
        return myLength != null;
    }

    public void addNode(ParserNode node) {
        myLength = node;
    }

    @Override
    public String toString() {
        return "BK " + myLength;
    }
}
