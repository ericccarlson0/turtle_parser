package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * A general-purpose Exepction for unexpected parsign exceptions that should be reported to the
 * developers to debug and handle
 *
 * @author Mariusz Derezinski-Choo
 */
public class UnexpectedParsingException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "UnexpectedParsingException";

    @Override
    public ParserNode renderNode(){
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }

}
