package parserModel.TurtleNodes;

import executables.Executable;
import executables.LTurnExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
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
