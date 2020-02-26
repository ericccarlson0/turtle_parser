package parserModel.nodes.turtleNodes;

import execution.HideExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;


public class HideNode extends CommandParserNode {

    public HideNode() {
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.hide();
        context.getExecutableQueue().add(new HideExecutable());
        return 0;
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "HIDE";
    }
}