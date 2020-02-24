package ParserModel;

public class ConstantNode extends ParserNode {

    private double myValue;

    public ConstantNode(double value){
        myValue = value;
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute() {
        return myValue;
    }

    @Override
    public int numberOfNodes() {
        return 0;
    }

    public String toString(){
        return "" + myValue;
    }
}
