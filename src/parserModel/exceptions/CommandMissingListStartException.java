package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class CommandMissingListStartException extends ParsingException{

    @Override
    public ParserNode toNode() {
        return new ErrorNode("ERROR: Missing Header at beginning of command definition");
    }
}
