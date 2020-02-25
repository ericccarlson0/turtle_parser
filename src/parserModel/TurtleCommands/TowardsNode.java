package parserModel.TurtleCommands;

import executables.Executable;
import executables.TowardsExecutable;
import java.util.List;
import parserModel.CommandParserNode;

public class TowardsNode extends CommandParserNode {
    private CommandParserNode myXNode;
    private CommandParserNode myYNode;
    private List<Executable> executableQueue;

    public TowardsNode(List<Executable> queue) {
        executableQueue = queue;
    }

    public void addNode(CommandParserNode node) {
        if (myXNode == null) {
            myXNode = node;
        } else if (myYNode == null) {
            myYNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public double execute() {
        double xTowards = myXNode.execute();
        double yTowards = myYNode.execute();
        executableQueue.add(new TowardsExecutable(xTowards, yTowards));
        return xTowards; // TODO (is this return correct?)
    }

    public boolean isComplete() {
        return myYNode != null;
    }

    @Override
    public String toString(){
        return "TOWARDS: " + myXNode + " " + myYNode;
    }
}
