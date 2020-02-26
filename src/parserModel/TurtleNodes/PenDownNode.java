package parserModel.TurtleNodes;

import executables.Executable;
import executables.PenDownExecutable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;

import visualizer.VisualContext;

import parserModel.TurtleData;
public class PenDownNode extends CommandParserNode {

    public PenDownNode(){
    }

    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }


    public double execute(VisualContext context) {
        TurtleData td = GlobalData.getInstance().turtleData();
        td.penDown();
        context.getExecutableQueue().add(new PenDownExecutable());
        return 0;
    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "PENDOWN";
    }
}
