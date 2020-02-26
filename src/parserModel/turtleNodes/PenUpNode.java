package parserModel.turtleNodes;

import execution.Executable;
import execution.PenUpExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
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
