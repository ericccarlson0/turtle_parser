package parserModel.TurtleCommands;

import executables.Executable;
import executables.HideExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class HideNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public HideNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        executableQueue.add(new HideExecutable());
        return 0; //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "HIDE";
    }
}
