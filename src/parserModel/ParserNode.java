package parserModel;

import execution.Executable;
import java.util.Queue;
import visualizer.VisualContext;

public abstract class ParserNode {
    public enum NodeType {
        COMMAND,
        LOOP,
        LIST_END,
        FUNCTION_DEFINITION
    }
    public abstract void addNode(ParserNode node);
    public abstract double execute(VisualContext context);
    public abstract boolean isComplete();
    public abstract NodeType typeOfNode();
}
