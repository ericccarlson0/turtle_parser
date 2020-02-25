package parserModel.TurtleCommands;

import parserModel.ParserNode;

public class HomeNode extends ParserNode {

    public HomeNode(){
        super();
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute() {
        System.out.println(toString());

        return 0; //FIXME
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "Home";
    }
}
