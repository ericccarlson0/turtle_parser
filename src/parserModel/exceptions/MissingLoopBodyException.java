package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

/**
 * An Exception that represents when a loop does not have
 * a body, i.e a list of commands to execute after the header
 * which defines the variable and increment with which to
 * execute the body
 *
 * @author Mariusz Derezinski-Choo
 */
public class MissingLoopBodyException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "MissingLoopBody";

    /**
     * fetch a ParserNode that can be executed in response to the exception
     * @return a ParserNode that can be executed in response to the exception
     */
    @Override
    public ParserNode toNode() {
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
