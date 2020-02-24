package ParserModel.Commands;

import ParserModel.ParserNode;

public class BackwardNode extends ParserNode {
    private ParserNode myLength;

    public BackwardNode(){

    }

    @Override
    public double execute() {
        System.out.println(toString());
        return 0; //FIXME
    }

    @Override
    public int numberOfNodes() {
        return 1;
    }

    @Override
    public void addNode(ParserNode node) {
        myLength = node;
    }

    @Override
    public String toString(){
        return "Moving backward " + myLength.execute();
    }
}
