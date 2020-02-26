package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class NonVariableInLoopHeaderException extends ParsingException {
    @Override
    public ParserNode toNode() {
        return new ErrorNode("Error: The first token inside the loop header must be a variable");
    }
}
