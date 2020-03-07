package parserModel.exceptions;

import parserModel.nodes.ParserNode;

public class InsufficientArgumentException extends ParsingException {

    public InsufficientArgumentException(String argument){

    }

    @Override
    public ParserNode renderNode() {
        return null;
    }
}
