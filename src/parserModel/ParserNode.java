package parserModel;

import executables.Executable;

import java.util.Queue;

public abstract class ParserNode {
    public enum NodeType{
        COMMAND,
        LOOP,
        LISTEND
    }
    public Queue<Executable> executableQueue;
    public abstract void addNode(CommandParserNode node);
    public abstract double execute();
    public abstract boolean isComplete();
    public abstract NodeType typeOfNode();
}
