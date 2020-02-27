package parserModel.exceptions;

import parserModel.nodes.ParserNode;

import java.util.ResourceBundle;

public abstract class ParsingException extends RuntimeException{
    protected static final ResourceBundle ERROR_MESSAGE_RESOURCES = ResourceBundle.getBundle("exceptions.resources.English.properties");

    public abstract ParserNode toNode();
}
