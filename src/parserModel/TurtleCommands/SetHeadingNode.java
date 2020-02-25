package parserModel.TurtleCommands;

<<<<<<< HEAD:src/parserModel/TurtleCommands/HeadingNode.java
import parserModel.CommandParserNode;

public class HeadingNode extends CommandParserNode {
    public CommandParserNode myDegrees;

    public HeadingNode(){
        super();
=======
import executables.Executable;
import executables.SetHeadingExecutable;
import java.util.List;
import parserModel.ParserNode;

public class SetHeadingNode extends ParserNode {
    public ParserNode myDegrees;
    private List<Executable> executableQueue;

    public SetHeadingNode(List<Executable> queue) {
        executableQueue = queue;
>>>>>>> 2df930122c4d7078d8d74e12ff85926a53b6ad0f:src/parserModel/TurtleCommands/SetHeadingNode.java
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
<<<<<<< HEAD:src/parserModel/TurtleCommands/HeadingNode.java
        double degreesToRotate = myDegrees.execute();
        System.out.println(toString());
        //iplementi
        return degreesToRotate;
=======
        double degrees = myDegrees.execute();
        executableQueue.add(new SetHeadingExecutable(degrees));
        return degrees;
>>>>>>> 2df930122c4d7078d8d74e12ff85926a53b6ad0f:src/parserModel/TurtleCommands/SetHeadingNode.java
    }

    @Override
    public boolean isComplete() {
        return myDegrees == null;
    }

    @Override
    public String toString(){
<<<<<<< HEAD:src/parserModel/TurtleCommands/HeadingNode.java
        return "Setting Heading "+ myDegrees;
=======
        return "SETHEADING: " + myDegrees;
>>>>>>> 2df930122c4d7078d8d74e12ff85926a53b6ad0f:src/parserModel/TurtleCommands/SetHeadingNode.java
    }
}
