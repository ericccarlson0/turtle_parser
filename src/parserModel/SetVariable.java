package parserModel;

public class SetVariable extends CommandParserNode{
    private VariableNode myVariableNode;
    private ParserNode myAssignmentNode;
    @Override
    public void addNode(CommandParserNode node) {

    }

    @Override
    public double execute() {
        return 0;
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
