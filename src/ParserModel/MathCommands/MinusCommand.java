package ParserModel.MathCommands;

import ParserModel.UnaryOperationNode;

public class MinusCommand extends UnaryOperationNode {

    @Override
    public double execute() {
        return -1 * myArgumentNode.execute();
    }
}
