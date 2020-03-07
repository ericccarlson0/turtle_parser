package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An Exception that is thrown when a Parent Node does not have enough arguments
 * to execute itself
 *
 * @author Mariusz Derezinski-Choo
 */
public class InsufficientArgumentException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "InsufficientArgument";

    private ParserNode myNode;

    /**
     * Constrcut an InsufficientArgumentException
     * @param argument the argument that did not have enough arguments
     */
    public InsufficientArgumentException(String argument){
        myNode = new ErrorNode(String.format(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY),argument));
    }

    @Override
    public ParserNode renderNode() {
        return myNode;
    }
}
