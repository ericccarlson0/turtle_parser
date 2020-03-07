package parserModel.nodes.display;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;

public class ShapeNode extends MultipleExecutionNode {
    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        //return GlobalData.getInstance().turtleData().getShapeIndex();
        return 0.0; //FIXME!
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
