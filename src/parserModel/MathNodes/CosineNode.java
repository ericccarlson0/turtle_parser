package parserModel.MathNodes;

import parserModel.UnaryOperationNode;

public class CosineNode extends UnaryOperationNode {
    public double execute() {
        return Math.cos(myArgumentNode.execute() * Math.PI/180.0);
    }
}
