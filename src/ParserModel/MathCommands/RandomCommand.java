package ParserModel.MathCommands;

public class RandomCommand extends UnaryOperationNode{
    @Override
    public double execute() {
        return Math.random() * myArgumentNode.execute();
    }
}
