package ParserModel.MathCommands;

import ParserModel.UnaryOperationNode;

public class SineCommand extends UnaryOperationNode {

    @Override
    public double execute() {
        return Math.sin(myArgumentNode.execute() * Math.PI / 180.0);
    }
}
