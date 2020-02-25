package parserModel.TurtleCommands;

import executables.Executable;
import executables.RTurnExecutable;
import java.util.List;
import parserModel.CommandParserNode;

public class RTurnNode extends CommandParserNode {
    private CommandParserNode myRotationNode;
    private List<Executable> executableQueue;

    public RTurnNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(CommandParserNode node) {
        if (myRotationNode == null){
            myRotationNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public double execute() {
        double degrees = myRotationNode.execute();
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
