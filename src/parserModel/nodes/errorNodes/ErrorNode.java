package parserModel.nodes.errorNodes;

import execution.ErrorReportingExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import parserModel.TurtleContext;

/**
 * A Node that represents an error. upon execution, the
 * error message is passed to the View to be displayed to the
 * user
 *
 * @author Mariusz Derezinski-Choo
 */
public class ErrorNode extends CommandParserNode {
    private String myError;

    /**
     * construct an ErrorNode
     * @param error the error message represented as a String
     */
    public ErrorNode(String error){
        myError = error;
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(TurtleContext context) {
        context.getExecutableQueue().add(new ErrorReportingExecutable(myError));
        return 0;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
