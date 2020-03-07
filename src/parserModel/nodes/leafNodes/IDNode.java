package parserModel.nodes.leafNodes;

import parserModel.TurtleContext;

public class IDNode extends LeafNode {

    public IDNode(String text) {
        super(text);
    }

    @Override
    public double execute(TurtleContext context) {
        return context.getWorkingID();
    }
}
