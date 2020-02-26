package parserModel.TurtleNodes;

import executables.ClearExecutable;
import executables.Executable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class ClearNode extends CommandParserNode {

    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    public double execute(VisualContext context) {
        context.getExecutableQueue().add(new ClearExecutable());
        return 0; //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "CLEAR";
    }
}
