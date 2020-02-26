package parserModel.exceptions;

import parserModel.nodes.ParserNode;

public abstract class ParsingException extends RuntimeException{
    public abstract ParserNode toNode();
}
