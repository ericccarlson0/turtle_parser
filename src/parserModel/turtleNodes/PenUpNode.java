package parserModel.turtleNodes;

import execution.Executable;
import execution.PenUpExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class PenUpNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public PenUpNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.penUp();
        executableQueue.add(new PenUpExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){ return "PENUP"; }
}
