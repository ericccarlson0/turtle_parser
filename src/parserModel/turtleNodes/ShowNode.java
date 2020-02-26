package parserModel.turtleNodes;

import execution.Executable;
import execution.ShowExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

public class ShowNode extends CommandParserNode {

    public ShowNode() {}

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.show();
        context.getExecutableQueue().add(new ShowExecutable());
        return 0;

    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "SHOW";
    }
}
