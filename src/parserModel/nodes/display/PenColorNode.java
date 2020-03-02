package parserModel.nodes.display;

import execution.HideExecutable;
import parserModel.GlobalData;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

public class PenColorNode extends CommandParserNode {
    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        return GlobalData.getInstance().turtleData().getPenColor();
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
