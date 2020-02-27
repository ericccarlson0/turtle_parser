package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

import java.util.ResourceBundle;

/**
 * An Exception that represents when a Loop header is not
 * valid. this occurs becuase the loop does not specify the correct number
 * of values (either 1 or 3)
 *
 * @author Mariusz Derezinski-Choo
 */
public class InvalidLoopHeaderException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "InvalidLoopHeader";

    /**
     * fetch a ParserNode that can be executed in response to the exception
     * @return a ParserNode that can be executed in response to the exception
     */
    @Override
    public ParserNode toNode() {
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
