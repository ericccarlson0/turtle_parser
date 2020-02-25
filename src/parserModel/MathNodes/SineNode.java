package parserModel.MathNodes;

import parserModel.UnaryOperationNode;

public class SineNode extends UnaryOperationNode {
    public double execute() {
        return Math.sin(myArgumentNode.execute() * Math.PI/180.0);
    }
}
