package ParserModel.TurtleCommands;

import ParserModel.ParserNode;

public class BackwardNode extends ParserNode {
    private ParserNode myLength;

    public BackwardNode(){
        super();
    }

    @Override
    public double execute() {
        double distanceToTravel = myLength.execute();
        System.out.println(toString());
        //TODO
        return distanceToTravel;
    }

    @Override
    public boolean isComplete() {
        return myLength != null;
    }

    @Override
    public void addNode(ParserNode node) {
        myLength = node;
    }

    @Override
    public String toString(){
        return "Moving backward " + myLength;
    }
}
