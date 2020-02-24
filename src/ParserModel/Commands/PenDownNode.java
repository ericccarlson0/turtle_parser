package ParserModel.Commands;

import ParserModel.ParserNode;

public class PenDownNode extends ParserNode {

    public PenDownNode(){
        super();
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute() {
        System.out.println(toString());
        //TODO
        return 1;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "Pen Down";
    }
}
