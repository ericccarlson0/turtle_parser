package parserModel;

public class ConstantNode extends CommandParserNode {
    private double myValue;

    public ConstantNode(double value){
        myValue = value;
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    public double execute() {
        return myValue;
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "" + myValue;
    }
}