package parserModel.exceptions;

import parserModel.nodes.ParserNode;
import java.util.ResourceBundle;

/**
 * An abstract superclass that defines the behavior of an Exception that occurs during parsing.
 *
 * @author Mariusz Derezinski-Choo
 */
public abstract class ParsingException extends RuntimeException{
    protected static final ResourceBundle ERROR_MESSAGE_RESOURCES = ResourceBundle.getBundle("parserModel.exceptions.resources.English");
    public abstract ParserNode renderNode();

}
