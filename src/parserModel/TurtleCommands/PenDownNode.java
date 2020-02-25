package parserModel.TurtleCommands;

import executables.Executable;
import executables.PenDownExecutable;
import java.util.List;
import parserModel.CommandParserNode;

public class PenDownNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public PenDownNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(CommandParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        executableQueue.add(new PenDownExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "PENDOWN";
    }
}
