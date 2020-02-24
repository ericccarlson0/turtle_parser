package ParserModel;

public abstract class ParserNode {


    public abstract void addNode(ParserNode node);

    public abstract double execute();

    public abstract boolean isComplete();
}
