package ParserModel.TurtleCommands;

import ParserModel.ParserNode;

public class HeadingNode extends ParserNode {
    public ParserNode myDegrees;

    public HeadingNode(){
        super();
    }

    @Override
    public void addNode(ParserNode node) {
        if(myDegrees == null) {
            myDegrees = node;
        } else{
            // throw exception
        }
    }

    @Override
    public double execute() {
        double degreesToRotate = myDegrees.execute();
        System.out.println(toString());
        //implement
        return degreesToRotate;
    }

    @Override
    public boolean isComplete() {
        return myDegrees == null;
    }

    @Override
    public String toString(){
        return "Setting Heading "+ myDegrees;
    }
}
