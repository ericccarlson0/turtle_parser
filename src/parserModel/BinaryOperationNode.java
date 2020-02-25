package parserModel;

public abstract class BinaryOperationNode extends CommandParserNode {
    protected CommandParserNode operand1;
    protected CommandParserNode operand2;

    public void addNode(CommandParserNode node) {
        if (operand1 == null) {
            operand1 = node;
        } else if (operand2 == null) {
            operand2 = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public boolean isComplete() { return operand2 != null; }
}
