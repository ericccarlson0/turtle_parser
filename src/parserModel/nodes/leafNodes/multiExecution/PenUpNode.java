package parserModel.nodes.leafNodes;

import execution.PenDownExecutable;
import parserModel.TurtleContext;
import parserModel.TurtleData;
import parserModel.nodes.ParserNode;
import parserModel.nodes.control.VariableNode;

/**
 * A node that when executed, sets the pen up
 * in the visualizer so that the turtle will not draw if moved
 *
 * @author Mariusz Derezinski-Choo
 */
public class PenUpNode extends LeafNode {
    private static final double TRUE = 1.0;
    private static final double FALSE = 0.0;

    public double execute(TurtleContext context) {
        return context.getWorkingTurtle().getPenDown()? FALSE : TRUE;
    }
}
