package parserModel.TurtleCommands;

import executables.Executable;
import executables.ForwardExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class ForwardNode extends CommandParserNode {
    private ParserNode myLength;
    private List<Executable> executableQueue;

    public ForwardNode(List<Executable> queue){
        executableQueue = queue;
    }

    public double execute() {
        double distance = myLength.execute();
        executableQueue.add(new ForwardExecutable(distance));
        return distance;
    }

    public boolean isComplete(){
        return myLength != null;
    }

    public void addNode(ParserNode node) { myLength = node; }

    @Override
    public String toString(){
        return "FD " + myLength;
    }
}
