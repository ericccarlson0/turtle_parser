package parserModel.mathNodes;

import parserModel.UnaryOperationNode;

public class ArctanNode extends UnaryOperationNode {
    public double execute() {
        return (180/Math.PI) * Math.atan(myArgumentNode.execute() * Math.PI/180);
    }
}
