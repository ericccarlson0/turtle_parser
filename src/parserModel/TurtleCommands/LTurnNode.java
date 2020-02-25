package parserModel.TurtleCommands;

import executables.Executable;
import executables.LTurnExecutable;
import java.util.List;
import parserModel.ParserNode;

public class LTurnNode extends ParserNode {
    private ParserNode myRotationNode;
    private List<Executable> executableQueue;

    public LTurnNode(List<Executable> queue) {
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
        executableQueue.add(new LTurnExecutable(degrees));
        return degrees;
    }

    public boolean isComplete() {
        return myRotationNode != null;
    }

    public String toString(){
        return "LT: " + myRotationNode;
    }
}
