package parserModel.TurtleNodes;

import executables.Executable;
import executables.ForwardExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
import visualizer.VisualContext;
import parserModel.TurtleData;

public class ForwardNode extends CommandParserNode {
    private ParserNode myLength;

    public ForwardNode(){
    }

    public double execute(VisualContext context) {
        double distance = myLength.execute(context);
        System.out.println("forward " + distance);
        TurtleData td = GlobalData.getInstance().turtleData();
        td.forward(distance);
        for(int i=0; i<distance; i++){
            context.getExecutableQueue().add(new ForwardExecutable(1));
        }
        //executableQueue.add(new ForwardExecutable(distance));
        return distance;
    }

    public boolean isComplete(){
        return myLength != null;
    }

    public void addNode(ParserNode node) { myLength = node; }

    @Override
    public String toString(){
        return "FD " + myLength;
    }
}
