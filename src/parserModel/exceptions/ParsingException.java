package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import java.util.ResourceBundle;

/**
 * An abstract superclass that defines the behavior of an Exception that occurs during parsing.
 *
 * @author Mariusz Derezinski-Choo
 */
public abstract class ParsingException extends RuntimeException{
    /**
     * retrieve a ParserNode that corresponds to the actions that should be taken in response to this Exception
     *
     * @return a ParserNode that is to be executed in response to the Exception
     */
    protected static final ResourceBundle ERROR_MESSAGE_RESOURCES = ResourceBundle.getBundle("exceptions.resources.English.properties");

    public abstract ParserNode toNode();
}
