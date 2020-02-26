package parserModel.nodes.turtleNodes;

import execution.BackwardExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.GlobalData;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

public class BackwardNode extends CommandParserNode {
    private ParserNode myLength;

    public BackwardNode(){
        super();
    }

    public double execute(VisualContext context) {
        double distance = myLength.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        td.backward(distance);
        context.getExecutableQueue().add(new BackwardExecutable(distance));
        return distance;
    }

    public boolean isComplete() {
        return myLength != null;
    }

    public void addNode(ParserNode node) {
        myLength = node;
    }

    @Override
    public String toString() {
        return "BK " + myLength;
    }
}
