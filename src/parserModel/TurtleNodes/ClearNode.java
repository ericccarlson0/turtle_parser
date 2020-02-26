package parserModel.TurtleNodes;

import executables.ClearExecutable;
import executables.Executable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class ClearNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public ClearNode(List<Executable> queue) {
        executableQueue = queue;
    }

    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    public double execute() {
        GlobalData.getInstance().clear();
        executableQueue.add(new ClearExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "CLEAR";
    }
}
