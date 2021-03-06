package parserModel.exceptions;


import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.ErrorNode;

/**
 * An Exception that represents when a Loop structure is Invalid
 * this occurs because the loop does not have a list as a header that
 * specifies a variable and increments
 *
 * @author Mariusz Derezinski-Choo
 */
public class InvalidLoopStructureException extends ParsingException{
    private static final String ERROR_MESSAGE_KEY = "InvalidLoopStructure";

    @Override
    public ParserNode renderNode(){
        return new ErrorNode(ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY));
    }
}
