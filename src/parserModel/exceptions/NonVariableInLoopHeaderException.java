package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

import java.util.ResourceBundle;

/**
 * An Exception that represents when a Loop header does not
 * begin with a variable. a loop header must begin with a
 * variable which will then be incremented across
 *
 * @author Mariusz Derezinski-Choo
 */
public class NonVariableInLoopHeaderException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "NonVariableInLoopHeader";

    /**
     * fetch a ParserNode that can be executed in response to the exception
     * @return a ParserNode that can be executed in response to the exception
     */
    @Override
    public ParserNode toNode() {
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
