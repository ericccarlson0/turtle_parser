package parserModel;

public abstract class BinaryOperationNode extends CommandParserNode {
    protected ParserNode operand1;
    protected ParserNode operand2;

    public void addNode(ParserNode node) {
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
