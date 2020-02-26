package parserModel.turtleNodes;

import execution.Executable;
import execution.PenDownExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class PenDownNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public PenDownNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.penDown();
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
