package parserModel.mathNodes;

import parserModel.UnaryOperationNode;

public class TangentNode extends UnaryOperationNode {
    public double execute() {
        return Math.tan(myArgumentNode.execute() * Math.PI/180.0);
    }
}
