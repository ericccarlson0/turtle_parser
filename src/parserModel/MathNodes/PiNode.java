package parserModel.MathNodes;

import parserModel.ParserNode;

public class PiNode extends ParserNode {
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }
    public double execute() {
        return Math.PI;
    }
    public boolean isComplete() {
        return true;
    }
}
