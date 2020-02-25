package parserModel.TurtleCommands;

import executables.BackwardExecutable;
import executables.Executable;
import java.util.List;
import parserModel.ParserNode;

public class BackwardNode extends ParserNode {
    private ParserNode myLength;
    private List<Executable> executableQueue;

    public BackwardNode(List<Executable> queue){
        executableQueue = queue;
    }

    public double execute() {
        double distance = myLength.execute();
        executableQueue.add(new BackwardExecutable(distance));
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
