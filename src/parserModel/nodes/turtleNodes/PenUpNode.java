package parserModel.nodes.turtleNodes;

import execution.PenUpExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

public class PenUpNode extends CommandParserNode {

    public PenUpNode() {
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.penUp();
        context.getExecutableQueue().add(new PenUpExecutable());
        return 0; //FIXME?
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){ return "PENUP"; }
}
