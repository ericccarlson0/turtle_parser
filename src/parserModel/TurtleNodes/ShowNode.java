package parserModel.TurtleNodes;

import executables.Executable;
import executables.ShowExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class ShowNode extends CommandParserNode {

    public ShowNode() {}

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
        context.getExecutableQueue().add(new ShowExecutable());
        return 0; //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "SHOW";
    }
}
