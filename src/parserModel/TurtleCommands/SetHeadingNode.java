package parserModel.TurtleCommands;

import executables.Executable;
import executables.SetHeadingExecutable;
import java.util.List;
import parserModel.ParserNode;

public class SetHeadingNode extends ParserNode {
    public ParserNode myDegrees;
    private List<Executable> executableQueue;

    public SetHeadingNode(List<Executable> queue) {
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
        executableQueue.add(new SetHeadingExecutable(degrees));
        return degrees;
    }

    public boolean isComplete() {
        return myDegrees != null;
    }

    @Override
    public String toString(){
        return "SETHEADING: " + myDegrees;
    }
}
