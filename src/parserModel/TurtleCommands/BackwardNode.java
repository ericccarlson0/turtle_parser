package parserModel.TurtleCommands;

import ParserStack.ParserStack;

import parserModel.ParserNode;
import executables.;


public class BackwardNode extends ParserNode {
    private ParserNode myLength;

    public BackwardNode(){
        super();
    }

    public double execute(ParserStack parserStack) {
        /*
        double distanceToTravel = myLength.execute();
        System.out.println(toString());
        //TODO
        return distanceToTravel;
         */
        //ps.pushCommand(new backExecutable())
        parserStack.pushCommand(new backExecutable(myLength.execute()));
        return 0;
    }

    public boolean isComplete() {
        return myLength != null;
    }

    public void addNode(ParserNode node) {
        myLength = node;
    }

    @Override
    public String toString() {
        return "BK " + myLength;
    }
}
