package parserModel.nodes.mathNodes;

import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the constant Pi
 *
 * @author Mariusz Derezinski-Choo
 */
public class PiNode extends CommandParserNode {
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }
    public double execute(TurtleContext context) {
        return Math.PI;
    }
    public boolean isComplete() {
        return true;
    }
}
