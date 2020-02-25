package parserModel.TurtleNodes;
import execution.Executable;
import execution.SetHeadingExecutable;
import java.util.List;
import parserModel.ParserNode;
import parserModel.CommandParserNode;


public class SetHeadingNode extends CommandParserNode {
    public ParserNode myDegrees;
    private List<Executable> executableQueue;

    public SetHeadingNode(List<Executable> queue) {
        executableQueue = queue;
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
        double degrees = myDegrees.execute();
        executableQueue.add(new SetHeadingExecutable(degrees));
        return degrees;
    }

    @Override
    public boolean isComplete() {
        return myDegrees == null;
    }

    @Override
    public String toString(){
        return "SETHEADING: " + myDegrees;
    }
}
