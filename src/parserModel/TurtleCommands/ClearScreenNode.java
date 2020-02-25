package parserModel.TurtleCommands;

import parserModel.ParserNode;

public class ClearScreenNode extends ParserNode {

    public ClearScreenNode(){
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
        return 0; //FIXME
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "Clearing Screen";
    }
}
