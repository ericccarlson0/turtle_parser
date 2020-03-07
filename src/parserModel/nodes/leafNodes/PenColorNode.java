package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

public class PenColorNode extends LeafNode {

    public PenColorNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getWorkingTurtle().getPenColor();
    }
}
