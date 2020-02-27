package parserModel.nodes.turtleNodes;

import execution.ClearExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
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
