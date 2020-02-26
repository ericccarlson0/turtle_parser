package parserModel.TurtleNodes;

import executables.Executable;
import executables.RTurnExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

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
