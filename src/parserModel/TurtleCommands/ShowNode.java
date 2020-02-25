package parserModel.TurtleCommands;

import executables.Executable;
import executables.ShowExecutable;
import java.util.List;
import parserModel.ParserNode;

public class ShowNode extends ParserNode {
    private List<Executable> executableQueue;

    public ShowNode(List<Executable> queue) { executableQueue = queue; }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        executableQueue.add(new ShowExecutable());
        return 0; //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "SHOW";
    }
}
