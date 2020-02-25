package parserModel.MathCommands;

import parserModel.UnaryOperationNode;

public class LogCommand extends UnaryOperationNode {
    @Override
    public double execute() {
        return Math.log(myArgumentNode.execute());
    }
}
