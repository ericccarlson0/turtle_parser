package ParserModel.Commands;

import ParserModel.ParserNode;

public class HomeNode extends ParserNode {
    @Override
    public void addNode(ParserNode node) {

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
