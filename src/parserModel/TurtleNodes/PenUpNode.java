package parserModel.TurtleCommands;

import parserModel.ParserNode;

public class PenUpNode extends ParserNode {


    public PenUpNode(){
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
        return 0;
    }


    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "Pen Up";
    }
}
