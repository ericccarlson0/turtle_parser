package parserModel.TurtleNodes;

import execution.Executable;
import execution.ShowExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class ShowNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public ShowNode(List<Executable> queue) { executableQueue = queue; }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.show();
        executableQueue.add(new ShowExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "SHOW";
    }
}
