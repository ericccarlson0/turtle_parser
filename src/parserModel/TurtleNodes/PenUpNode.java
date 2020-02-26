package parserModel.TurtleNodes;

import executables.Executable;
import executables.PenUpExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class PenUpNode extends CommandParserNode {

    public PenUpNode() {
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
        context.getExecutableQueue().add(new PenUpExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){ return "PENUP"; }
}
