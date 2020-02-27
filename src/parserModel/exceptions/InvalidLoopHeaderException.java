package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

import java.text.ParseException;

public class InvalidLoopHeaderException extends ParsingException {


    @Override
    public ParserNode toNode() {
        return new ErrorNode("ERROR: Invalid dimensions for loop header");
    }
}