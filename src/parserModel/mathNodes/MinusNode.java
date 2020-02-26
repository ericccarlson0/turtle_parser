package parserModel.mathNodes;

import parserModel.UnaryOperationNode;

public class MinusNode extends UnaryOperationNode {
    public double execute() { return -1 * myArgumentNode.execute(); }
}
