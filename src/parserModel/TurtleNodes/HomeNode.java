package parserModel.TurtleNodes;

import executables.Executable;
import executables.HomeExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class HomeNode extends CommandParserNode {

    public HomeNode() {
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
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
