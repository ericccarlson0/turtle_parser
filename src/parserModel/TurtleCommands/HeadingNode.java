package parserModel.TurtleCommands;

import executables.Executable;
import executables.HeadingExecutable;
import java.util.List;
import parserModel.ParserNode;

public class HeadingNode extends ParserNode {
    public ParserNode myDegrees;
    private List<Executable> executableQueue;

    public HeadingNode(List<Executable> queue) {
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        if (myDegrees == null) {
            myDegrees = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public double execute() {
        double degrees = myDegrees.execute();
        executableQueue.add(new HeadingExecutable(degrees));
        return degrees;
    }

    public boolean isComplete() {
        return myDegrees != null;
    }

    @Override
    public String toString(){
        return "HEADING: " + myDegrees;
    }
}
