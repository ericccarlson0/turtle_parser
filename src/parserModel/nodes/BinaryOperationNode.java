package parserModel.nodes;

/**
 * An abstract class that extends CommandParserNode and provides core
 * functionality for a node that requires two children. the only method
 * not implemented is execute, which will vary from subclass to subclass
 *
 * @author Mariusz Derezinski-Choo
 */
public abstract class BinaryOperationNode extends CommandParserNode {
    protected ParserNode operand1;
    protected ParserNode operand2;

    @Override
    public void addNode(ParserNode node) {
        if (operand1 == null) {
            operand1 = node;
        } else if (operand2 == null) {
            operand2 = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean isComplete() { return operand2 != null; }
}
