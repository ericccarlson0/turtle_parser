package parserModel.turtleNodes;

<<<<<<< HEAD
import execution.Executable;
=======
import executables.Executable;
import executables.HeadingExecutable;
>>>>>>> master
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import parserModel.TurtleData;

public class TowardsNode extends CommandParserNode {
    private ParserNode myXNode;
    private ParserNode myYNode;
    private List<Executable> executableQueue;

    public TowardsNode(List<Executable> queue) {
        executableQueue = queue;
    }

    public void addNode(ParserNode node) {
        if (myXNode == null) {
            myXNode = node;
        } else if (myYNode == null) {
            myYNode = node;
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public double execute() {
        TurtleData td = GlobalData.getInstance().turtleData();
        double xDiff = myXNode.execute() - td.getX();
        double yDiff = myYNode.execute() - td.getY();
        double degrees = Math.atan(yDiff/xDiff);
        td.setHeading(degrees);
        executableQueue.add(new HeadingExecutable(degrees));
        return 0.0; // TODO (is this return correct?)
    }

    public boolean isComplete() {
        return myYNode != null;
    }

    @Override
    public String toString(){
        return "TOWARDS: " + myXNode + " " + myYNode;
    }
}
