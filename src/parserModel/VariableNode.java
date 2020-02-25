package parserModel;

public class VariableNode extends CommandParserNode {

    @Override
    public void addNode(CommandParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute() {
        return 1.0; //TODO
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
