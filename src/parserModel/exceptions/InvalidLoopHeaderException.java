package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An Exception that represents when a Loop header is not
 * valid. this occurs becuase the loop does not specify the correct number
 * of values (either 1 or 3)
 *
 * @author Mariusz Derezinski-Choo
 */
public class InvalidLoopHeaderException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "InvalidLoopHeader";

    @Override
    public ParserNode renderNode(){
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
