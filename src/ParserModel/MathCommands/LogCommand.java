package ParserModel.MathCommands;

import ParserModel.UnaryOperationNode;

public class LogCommand extends UnaryOperationNode {
    @Override
    public double execute() {
        return Math.log(myArgumentNode.execute());
    }
}
