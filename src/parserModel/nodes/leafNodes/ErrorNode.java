package parserModel.nodes.leafNodes;

import execution.ErrorReportingExecutable;
import parserModel.TurtleContext;

/**
 * A Node that represents an error. upon execution, the
 * error message is passed to the View to be displayed to the
 * user
 *
 * @author Mariusz Derezinski-Choo
 */
public class ErrorNode extends LeafNode {
    private static final double RETURN_VALUE = 0.0;

    /**
     * construct an ErrorNode
     * @param error the error message represented as a String
     */
    public ErrorNode(String error){
        super(error);
    }

    @Override
    public double execute(TurtleContext context) {
        context.addToQueue(new ErrorReportingExecutable(myEnteredText));
        return RETURN_VALUE;
    }
}

