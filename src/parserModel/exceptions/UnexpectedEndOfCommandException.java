package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class UnexpectedEndOfCommandException extends ParsingException{

    @Override
    public ParserNode toNode() {
        return new ErrorNode("ERROR: reached end of command before parsing");
    }
}
