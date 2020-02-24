package ParserModel.MathCommands;

public class ArctanCommand extends UnaryOperationNode {

    @Override
    public double execute() {
        return 180 / Math.PI * Math.atan(myArgumentNode.execute());
    }
}
