package parserModel.TurtleNodes;

import executables.Executable;
import executables.RTurnExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class RTurnNode extends CommandParserNode {
    private ParserNode myRotationNode;
    private List<Executable> executableQueue;

    public RTurnNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public double execute() {
        double degrees = myRotationNode.execute();
        TurtleData td = GlobalData.getInstance().turtleData();
        td.turnClockwise(degrees);
        executableQueue.add(new RTurnExecutable(degrees));
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
