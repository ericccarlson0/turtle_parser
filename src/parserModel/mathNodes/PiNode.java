package parserModel.mathNodes;

import parserModel.CommandParserNode;
import parserModel.ParserNode;

public class PiNode extends CommandParserNode {
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
