package parserModel;

import execution.Executable;

import java.util.Queue;

public abstract class ParserNode {
    public enum NodeType {
        COMMAND,
        LOOP,
        LISTEND
        //FIXME (change to LIST_END ?)
    }
    public Queue<Executable> executableQueue;
    public abstract void addNode(ParserNode node);
    public abstract double execute();
    public abstract boolean isComplete();
    public abstract NodeType typeOfNode();
}
