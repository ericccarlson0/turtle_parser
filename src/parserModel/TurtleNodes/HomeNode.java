package parserModel.TurtleNodes;

import execution.Executable;
import execution.HomeExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class HomeNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public HomeNode(List<Executable> queue) {
       executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.home();
        executableQueue.add(new HomeExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "HOME";
    }
}
