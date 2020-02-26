package parserModel.TurtleNodes;
import executables.Executable;
import executables.SetHeadingExecutable;
import java.util.List;
import parserModel.ParserNode;
import executables.SetHeadingExecutable;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import parserModel.TurtleQueries.HeadingNode;
import visualizer.VisualContext;


public class SetHeadingNode extends CommandParserNode {
    public ParserNode myDegrees;

    public SetHeadingNode() {
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
    public double execute(VisualContext context) {
        double degrees = myDegrees.execute(context);
        context.getExecutableQueue().add(new SetHeadingExecutable(degrees));
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
