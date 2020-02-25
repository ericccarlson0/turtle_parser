package parserModel.MathNodes;

import parserModel.UnaryOperationNode;

public class LogNode extends UnaryOperationNode {
    public double execute() {
        return Math.log(myArgumentNode.execute());
    }
}
