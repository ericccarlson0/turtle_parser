package parserModel.TurtleNodes;

import executables.Executable;
import executables.PenDownExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class PenDownNode extends CommandParserNode {

    public PenDownNode(){
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
        context.getExecutableQueue().add(new PenDownExecutable());
        return 0; // FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "PENDOWN";
    }
}
