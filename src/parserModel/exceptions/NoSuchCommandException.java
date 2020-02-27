package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class NoSuchCommandException extends ParsingException {
    public NoSuchCommandException(){
        super();
    }

    @Override
    public ParserNode toNode() {
        return new ErrorNode("Command name not found!");
    }
}
