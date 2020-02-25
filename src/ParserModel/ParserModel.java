package ParserModel;

import java.util.List;

public interface ParserModel {
    /**
     * This represents the core functionality of the Parser API; it allows for a user-entered string
     * to be parsed and converted into objects that represent single actions and can be performed by
     * the Application
     *
     * @param userInput The String command that is to be parsed.
     * @return          A list of Action objects that should be performed.
     */
    public List<Action> generateActions(String userInput);

    /**
     * Parses a command and associates the resulting list of Actions with the name that is provided.
     * This implements the creation/storing of a user-defined function.
     *
     * @param name      The name that will be associated with the new command.
     * @param command   The String that will be parsed (by calling generateActions) and whose
     *                  resultant Actions will be stored.
     * @return          TRUE if the command was properly stored, FALSE otherwise
     */
    public boolean createCommand(String name, String command);

    /**
     * Remove a previously defined command from the command namespace. This command will no longer
     * be called.
     * @param name  The name of the command to be deleted.
     * @return      TRUE if the command was properly removed, FALSE otherwise.
     */
    public boolean removeCommand(String name);

    /**
     * Store a variable associated with a String identifier. Its value can be referenced later and
     * reused.
     * @param name  The name of the variable to be stored.
     * @param value The value that this variable should be associated with.
     * @return      TRUE if the variable was properly stored, FALSE otherwise.
     */
    public boolean createVariable(String name, double value);

    /**
     * Remove a previously stored variable. The variable will no longer be referenced following
     * this command.
     * @param name  The name of the variable to be deleted.
     * @return      TRUE if the variable was properly deleted, FALSE otherwise
     */
    public boolean removeVariable(String name);
}