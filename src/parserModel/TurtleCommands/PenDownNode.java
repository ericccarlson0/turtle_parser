package parserModel.TurtleCommands;

import executables.Executable;
import executables.PenDownExecutable;
import java.util.List;
import parserModel.ParserNode;

public class PenDownNode extends ParserNode {
    private List<Executable> executableQueue;

    public PenDownNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
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
