package parserModel.mathNodes;

import parserModel.CommandParserNode;
import parserModel.ParserNode;
import visualizer.VisualContext;

public class PiNode extends CommandParserNode {
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }
    public double execute(VisualContext context) {
        return Math.PI;
    }
    public boolean isComplete() {
        return true;
    }
}
