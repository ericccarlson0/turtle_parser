package parserModel.TurtleNodes;

import execution.Executable;
import execution.HideExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class HideNode extends CommandParserNode {
    private List<Executable> executableQueue;

    public HideNode(List<Executable> queue){
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.hide();
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
