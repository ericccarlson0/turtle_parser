package parserModel.nodes.turtleNodes;

import execution.ShowExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
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
