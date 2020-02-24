package ParserModel.MathCommands;

public class MinusCommand extends UnaryOperationNode{

    @Override
    public double execute() {
        return -1 * myArgumentNode.execute();
    }
}
