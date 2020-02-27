package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

import java.util.ResourceBundle;

/**
 * An Exception that represents when a command definition is not
 * followed by a list. all commands definitions must be followed by
 * a list of variables
 *
 * @author Mariusz Derezinski-Choo
 */
public class CommandMissingListStartException extends ParsingException{
    private static final String ERROR_MESSAGE_KEY = "CommandMissingList";

    /**
     * fetch a ParserNode that can be executed in response to the exception
     * @return a ParserNode that can be executed in response to the exception
     */
    @Override
    public ParserNode toNode() {
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
