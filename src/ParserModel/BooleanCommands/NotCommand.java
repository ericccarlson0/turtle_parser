package ParserModel.BooleanCommands;

import ParserModel.UnaryOperationNode;

public class NotCommand extends UnaryOperationNode {
    @Override
    public double execute() {
        return myArgumentNode.execute() == 0 ? 1.0 : 0.0;
    }
}
