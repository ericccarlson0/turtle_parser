package ParserModel.MathCommands;

import ParserModel.UnaryOperationNode;

public class TangentCommand extends UnaryOperationNode {
    @Override
    public double execute() {
        return Math.tan(myArgumentNode.execute() * Math.PI / 180.0);
    }
}
