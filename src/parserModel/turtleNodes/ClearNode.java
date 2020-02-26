package parserModel.turtleNodes;

import execution.ClearExecutable;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class ClearNode extends CommandParserNode {

    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    public double execute(VisualContext context) {
        GlobalData.getInstance().clear();
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
