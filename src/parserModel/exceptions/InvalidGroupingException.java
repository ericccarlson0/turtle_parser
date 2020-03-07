package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

public class InvalidGroupingException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "InvalidGrouping";

    private ParserNode myNode;

    public InvalidGroupingException(String command, String constraints){
        myNode = new ErrorNode(String.format(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY), command, constraints));
    }

    @Override
    public ParserNode renderNode() {
        return myNode;
    }
}
