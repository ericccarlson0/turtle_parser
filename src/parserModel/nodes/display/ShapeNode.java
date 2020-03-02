package parserModel.nodes.display;

import parserModel.GlobalData;
import parserModel.TurtleContext;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

public class ShapeNode extends CommandParserNode {
    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        return GlobalData.getInstance().turtleData().getShapeIndex();
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
