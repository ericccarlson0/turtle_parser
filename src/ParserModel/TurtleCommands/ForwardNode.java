package ParserModel.TurtleCommands;

import ParserModel.ParserNode;

public class ForwardNode extends ParserNode {
    private ParserNode myLength;

    public ForwardNode(){
        super();
    }

    @Override
    public double execute() {
        double distanceToMove = myLength.execute();
        System.out.println(toString() + " " + distanceToMove);
        //TODO
        return distanceToMove;
    }

    public boolean isComplete(){
        return myLength != null;
    }

    public void addNode(ParserNode node) { myLength = node; }

    @Override
    public String toString(){
        return "FD " + myLength;
    }
}
