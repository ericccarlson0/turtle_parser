package parserModel.TurtleCommands;

import executables.Executable;
import executables.HomeExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class HomeNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public HomeNode(List<Executable> queue) {
       executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        executableQueue.add(new HomeExecutable());
        return 0; //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "HOME";
    }
}
