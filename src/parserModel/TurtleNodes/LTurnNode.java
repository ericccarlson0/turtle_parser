package parserModel.TurtleNodes;

import executables.Executable;
import executables.LTurnExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

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
        double degrees = myRotationNode.execute(context);
        context.getExecutableQueue().add(new LTurnExecutable(degrees));
        return degrees;
    }

    public boolean isComplete() {
        return myRotationNode != null;
    }

    public String toString(){
        return "LT: " + myRotationNode;
    }
}
