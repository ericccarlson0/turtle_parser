package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

public class TurtlesNode extends LeafNode {
    public TurtlesNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getData().getAllTurtles().size();
    }
}
