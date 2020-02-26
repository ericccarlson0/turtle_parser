package parserModel;

import executables.Executable;
import visualizer.VisualContext;

import java.util.Queue;

public abstract class ParserNode {
    public enum NodeType {
        COMMAND,
        LOOP,
        LISTEND
        //FIXME (change to LIST_END ?)
    }
    public abstract void addNode(ParserNode node);
    public abstract double execute(VisualContext context);
    public abstract boolean isComplete();
    public abstract NodeType typeOfNode();
}
