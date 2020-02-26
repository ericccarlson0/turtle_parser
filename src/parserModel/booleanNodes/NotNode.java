package parserModel.booleanNodes;

import parserModel.UnaryOperationNode;

public class NotNode extends UnaryOperationNode {
    public double execute() { return (myArgumentNode.execute() == 0) ? 1.0 : 0.0; }
}
