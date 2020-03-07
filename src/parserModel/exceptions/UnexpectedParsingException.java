package parserModel.exceptions;

import parserModel.nodes.ParserNode;

public class UnexpectedParsingException extends ParsingException {

    @Override
    public ParserNode renderNode() {
        return null; //FIXME!
    }
}
