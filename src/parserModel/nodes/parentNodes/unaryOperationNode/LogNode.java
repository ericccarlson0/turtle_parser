package parserModel.nodes.parentNodes.unaryOperationNode;

import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Math Node that computes the natural logarithm of its child
 *
 * @author Mariusz Derezinski-Choo
 */
public class LogNode extends UnaryOperationNode {

    public LogNode(String text) {
        super(text);
    }

    @Override
    protected double evaluate(ParserNode node, TurtleContext context) {
        return Math.log(node.execute(context));
    }
}
