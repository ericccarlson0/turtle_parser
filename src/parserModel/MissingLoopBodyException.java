package parserModel;

import parserModel.exceptions.ParsingException;
import parserModel.nodes.ParserNode;

public class MissingLoopBodyException extends ParsingException {
    @Override
    public ParserNode toNode() {
        return null;
    }
}
