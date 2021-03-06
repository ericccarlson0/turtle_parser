package parserModel.exceptions;


import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An Exception that represents when a Loop header does not
 * begin with a variable. a loop header must begin with a
 * variable which will then be incremented across
 *
 * @author Mariusz Derezinski-Choo
 */
public class NonVariableInLoopHeaderException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "NonVariableInLoopHeader";

    @Override
    public ParserNode renderNode(){
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
