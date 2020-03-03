package parserModel.exceptions;

/**
 * An Exception that represents when a command definition is not
 * followed by a list. all commands definitions must be followed by
 * a list of variables
 *
 * @author Mariusz Derezinski-Choo
 */
public class CommandMissingListStartException extends ParsingException{
    private static final String ERROR_MESSAGE_KEY = "CommandMissingList";

    @Override
    public String errorMessage() {
        return ERROR_MESSAGE_RESOURCES.getString(ERROR_MESSAGE_KEY);
    }
}
