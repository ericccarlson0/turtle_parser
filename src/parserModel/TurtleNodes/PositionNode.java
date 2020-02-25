package parserModel.TurtleCommands;

import parserModel.ParserNode;

public class PositionNode extends ParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;

    @Override
    public void addNode(ParserNode node) {
        if(myXNode == null) {
            myXNode = node;
        } else if (myYNode == null){
            myYNode = node;
        } else{
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public double execute() {
        System.out.println(toString());

        //TODO
        return 0; //FIXME
    }

    @Override
    public boolean isComplete() {
        return myYNode != null;
    }

    @Override
    public String toString(){
        return "setxy" + myXNode + " " + myYNode;
    }
}
