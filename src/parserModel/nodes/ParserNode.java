package parserModel.nodes;

import visualizer.VisualContext;

public abstract class ParserNode {

    public abstract void addNode(ParserNode node);
    public abstract double execute(VisualContext context);
    public abstract boolean isComplete();
    public abstract NodeType typeOfNode();
}
