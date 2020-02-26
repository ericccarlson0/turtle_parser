package parserModel.turtleNodes;

import execution.ClearExecutable;
import execution.Executable;
import java.util.List;
import parserModel.CommandParserNode;
import parserModel.GlobalData;
import parserModel.ParserNode;
<<<<<<< HEAD:src/parserModel/turtleNodes/ClearNode.java
=======
import visualizer.VisualContext;
import parserModel.TurtleData;
>>>>>>> master:src/parserModel/TurtleNodes/ClearNode.java

public class ClearNode extends CommandParserNode {

    public void addNode(ParserNode node) { throw new UnsupportedOperationException(); }

    public double execute(VisualContext context) {
        GlobalData.getInstance().clear();
        context.getExecutableQueue().add(new ClearExecutable());
        return 0; //FIXME

    }

    public boolean isComplete() {
        return true;
    }

    @Override
    public String toString(){
        return "CLEAR";
    }
}
