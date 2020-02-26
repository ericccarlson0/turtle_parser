package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class MissingCommandBodyException extends ParsingException {

    @Override
    public ParserNode toNode() {
        return new ErrorNode("ERROR missing command body");
    }
}
