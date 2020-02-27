package parserModel.nodes.mathNodes;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

/**
 * A Math Node that computes the constant Pi
 *
 * @author Mariusz Derezinski-Choo
 */
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
