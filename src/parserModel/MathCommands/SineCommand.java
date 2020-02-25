package parserModel.MathCommands;

import parserModel.UnaryOperationNode;

public class SineCommand extends UnaryOperationNode {

    @Override
    public double execute() {
        return Math.sin(myArgumentNode.execute() * Math.PI / 180.0);
    }
}
