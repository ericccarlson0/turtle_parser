package ParserModel;

import ParserStack.ParserStack;

public abstract class ParserNode {
    public ParserStack ps = new ParserStack();
    public abstract void addNode(ParserNode node);
    public abstract double execute();
    public abstract boolean isComplete();
}
