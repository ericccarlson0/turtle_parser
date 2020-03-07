package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An exception that is thrown when a grouping it not done properly, i.e the first command is not capable of being grouped
 */
public class InvalidGroupingException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "InvalidGrouping";

    private ParserNode myNode;

    /**
     * Construct an InvalidGroupingException
     * @param command the command that was grouped improperly
     * @param constraints the constraints from which this command must operate
     */
    public InvalidGroupingException(String command, String constraints){
        myNode = new ErrorNode(String.format(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY), command, constraints));
    }

    @Override
    public ParserNode renderNode() {
        return myNode;
    }
}
