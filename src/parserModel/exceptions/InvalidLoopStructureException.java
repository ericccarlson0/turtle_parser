package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class InvalidLoopStructureException extends ParsingException{

    @Override
    public ParserNode toNode() {
        return new ErrorNode("Error: Missing Open Bracket at start of loop header");
    }
}
