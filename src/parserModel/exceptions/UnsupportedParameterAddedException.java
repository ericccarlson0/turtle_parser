package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

public class UnsupportedParameterAddedException extends ParsingException {
    private static final String ERROR_MESSAGE_KEY = "UnsupportedParameterAddition";

    private ParserNode myNode;

    public UnsupportedParameterAddedException(String leafID, String childID){
        myNode = new ErrorNode(String.format(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY), leafID, childID));
    }

    @Override
    public ParserNode renderNode() {
        return myNode;
    }
}
