package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

/**
 * An Exception that represents when parsing completes
 * but the command has not been sufficiently completed
 *
 * @author Mariusz Derezinski-Choo
 */
public class UnexpectedEndOfCommandException extends ParsingException{
    private static final String ERROR_MESSAGE_KEY = "UnexpectedEndOfCommand";

    /**
     * fetch a ParserNode that can be executed in response to the exception
     * @return a ParserNode that can be executed in response to the exception
     */
    @Override
    public ParserNode toNode() {
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
