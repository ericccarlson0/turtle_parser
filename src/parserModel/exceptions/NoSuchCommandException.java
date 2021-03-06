package parserModel.exceptions;


import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An Exception that represents when a Command does not exist
 *
 * @author Mariusz Derezinski-Choo
 */
public class NoSuchCommandException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "NoSuchCommand";


    private String myCommand;

    /**
     * Construct a NoSuchCommandException
     *
     * @param command the name of the command that does not exist
     */
    public NoSuchCommandException(String command) {
        super();
        myCommand = command;
    }

    @Override
    public ParserNode renderNode() {
        return new ErrorNode(String.format(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY),myCommand));
}
}
