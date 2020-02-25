package parserModel;

public class VariableNode extends CommandParserNode {
    private String myVariableName;

    public VariableNode(String variableName){
        myVariableName = variableName;
    }

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
