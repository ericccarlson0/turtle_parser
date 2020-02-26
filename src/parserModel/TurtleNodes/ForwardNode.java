package parserModel.TurtleNodes;

import executables.Executable;
import executables.ForwardExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class ForwardNode extends CommandParserNode {
    private ParserNode myLength;
    private List<Executable> executableQueue;

    public ForwardNode(List<Executable> queue){
        executableQueue = queue;
    }

    public double execute() {
        double distance = myLength.execute();
        TurtleData td = GlobalData.getInstance().turtleData();
        td.forward(distance);
        for (int i=0; i<distance; i++){
            executableQueue.add(new ForwardExecutable(1));
        }
        // FIXME executableQueue.add(new ForwardExecutable(distance));
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
