package ParserModel.MathCommands;

public class CosineCommand extends UnaryOperationNode {
    @Override
    public double execute() {
        return Math.cos(myArgumentNode.execute() * Math.PI / 180.0);
    }
}
