package parserModel.nodes.turtleNodes;

import execution.HomeExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

public class HomeNode extends CommandParserNode {

    public HomeNode() {
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }


    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.home();
        context.getExecutableQueue().add(new HomeExecutable());
        return 0; //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "HOME";
    }
}
