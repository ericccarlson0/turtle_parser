package parserModel.TurtleNodes;

import executables.Executable;
import executables.HideExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class HideNode extends CommandParserNode {

    public HideNode() {
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute(VisualContext context) {
        context.getExecutableQueue().add(new HideExecutable());
        return 0; //FIXME
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "HIDE";
    }
}
