package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An exception thrown in response to a parameter being added to a command that does not support
 * adding parameters
 *
 * @author Mariusz Derzinski-Choo
 */
public class UnsupportedParameterAddedException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "UnsupportedParameterAddition";

    private ParserNode myNode;

    /**
     * Construct the exception
     * @param leafID the id of the leaf that was added to
     * @param childID the child that was added to a leaf
     */
    public UnsupportedParameterAddedException(String leafID, String childID){
        myNode = new ErrorNode(String.format(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY), leafID, childID));
    }

    @Override
    public ParserNode renderNode() {
        return myNode;
    }
}
