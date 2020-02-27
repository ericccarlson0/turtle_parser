package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import parserModel.nodes.errorNodes.ErrorNode;

public class NoSuchCommandException extends ParsingException {
    private String myCommand;

    public NoSuchCommandException(String command){
        super();
        myCommand = command;
    }

    @Override
    public ParserNode toNode() {
        return new ErrorNode("Command '" + myCommand + "' is not defined!");
    }
}
