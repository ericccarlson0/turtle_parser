package parserModel.mathNodes;

import parserModel.UnaryOperationNode;

public class RandomNode extends UnaryOperationNode {
    public double execute() {
        return Math.random() * myArgumentNode.execute();
    }
}
