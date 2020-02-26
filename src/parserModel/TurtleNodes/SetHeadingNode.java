package parserModel.TurtleNodes;
import executables.Executable;
import executables.SetHeadingExecutable;
import java.util.List;
import parserModel.GlobalData;
import parserModel.ParserNode;
import executables.SetHeadingExecutable;
import parserModel.CommandParserNode;
import parserModel.ParserNode;
import parserModel.TurtleData;
import parserModel.TurtleQueries.HeadingNode;
import visualizer.VisualContext;


public class SetHeadingNode extends CommandParserNode {
    public ParserNode myDegrees;

    public SetHeadingNode() {
    }

    public void addNode(ParserNode node) {
        if (myDegrees == null) {
            myDegrees = node;
        } else {
            // TODO throw exception
        }
    }

    @Override
    public double execute(VisualContext context) {
        double degrees = myDegrees.execute(context);
        TurtleData td = GlobalData.getInstance().turtleData();
        td.setHeading(degrees);
        context.getExecutableQueue().add(new SetHeadingExecutable(degrees));
        return degrees;
    }

    public boolean isComplete() {
        return myDegrees == null;
    }

    @Override
    public String toString(){
        return "SETHEADING: " + myDegrees;
    }
}
