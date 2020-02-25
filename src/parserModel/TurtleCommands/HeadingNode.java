package parserModel.TurtleCommands;

import parserModel.CommandParserNode;

public class HeadingNode extends CommandParserNode {
    public CommandParserNode myDegrees;

    public HeadingNode(){
        super();
    }

    @Override
    public void addNode(CommandParserNode node) {
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
        //iplementi
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
