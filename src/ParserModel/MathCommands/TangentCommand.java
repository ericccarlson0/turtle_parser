package ParserModel.MathCommands;

public class TangentCommand extends UnaryOperationNode {
    @Override
    public double execute() {
        return Math.tan(myArgumentNode.execute() * Math.PI / 180.0);
    }
}
