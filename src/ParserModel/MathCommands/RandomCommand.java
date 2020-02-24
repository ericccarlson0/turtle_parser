package ParserModel.MathCommands;

import ParserModel.UnaryOperationNode;

public class RandomCommand extends UnaryOperationNode {
    @Override
    public double execute() {
        return Math.random() * myArgumentNode.execute();
    }
}
