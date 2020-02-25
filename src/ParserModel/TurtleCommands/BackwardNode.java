package ParserModel.TurtleCommands;

import ParserModel.ParserNode;
import controller.Executables.;


public class BackwardNode extends ParserNode {
    private ParserNode myLength;

    public BackwardNode(){
        super();
    }

    public double execute() {
        /*
        double distanceToTravel = myLength.execute();
        System.out.println(toString());
        //TODO
        return distanceToTravel;
         */
        ps.pushCommand(new backExecutable())

    }

    public boolean isComplete() {
        return myLength != null;
    }

    public void addNode(ParserNode node) {
        myLength = node;
    }

    @Override
    public String toString(){
        return "BK " + myLength;
    }
}
