package parserModel.turtleNodes;

import execution.Executable;
import execution.SetHeadingExecutable;
import java.util.List;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.CommandParserNode;
import parserModel.TurtleData;


public class SetHeadingNode extends CommandParserNode {
    public ParserNode myDegrees;
    private List<Executable> executableQueue;

    public SetHeadingNode(List<Executable> queue) {
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        if (myDegrees == null) {
            myDegrees = node;
        } else {
            // TODO throw exception
        }
    }

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        double degrees = myDegrees.execute();
        td.setHeading(degrees);
        executableQueue.add(new SetHeadingExecutable(degrees));
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
