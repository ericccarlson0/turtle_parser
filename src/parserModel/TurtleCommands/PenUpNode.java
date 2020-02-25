package parserModel.TurtleCommands;

import executables.Executable;
import executables.PenUpExecutable;
import java.util.List;
import parserModel.CommandParserNode;

public class PenUpNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public PenUpNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(CommandParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        executableQueue.add(new PenUpExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){ return "PENUP"; }
}
