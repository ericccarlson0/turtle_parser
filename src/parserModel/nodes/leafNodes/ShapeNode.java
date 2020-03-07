package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;

public class ShapeNode extends LeafNode {
    public ShapeNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getWorkingTurtle().getShapeIndex();
    }
}
