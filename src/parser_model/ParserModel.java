package parser_model;

import java.util.List;

public interface ParserModel {
    /**
     * takes a String command as an input, and returns a list of actions that should be taken on behalf of the controller
     * This is the core parsing functionality of the Parser API, as it allows for user-entered string to be parsed and
     * be converted into single-action Actions that can be performed on the Application
     *
     * @param command the String command that is to be parsed
     * @return A list of actions that should be taken
     */
    public List<Action> getCommands(String command);

    /**
     * parses a command, and stores the ensuing Actions as being associated with the commandName that is provided
     * this essentially implements the idea of storing a function, allowing for the user to define functions
     * with unique names an then subsequently call and build upon those functions
     *
     * @param commandName the name that will be associated with this command
     * @param command the String command that will be parsed and whose ensuing Actions will be stored
     * @return true if the command was properly stored, false otherwise
     */
    public boolean createCommand(String commandName, String command);

    /**
     * Remove a previously defined command from the command namespace. this command
     * will no longer be able to be called.
     * @param commandName the name of the command to be deleted
     * @return true if the command was properly removed, false otherwise
     */
    public boolean removeCommand(String commandName);

    /**
     * Store a variable associated with a String identifier. This is akin to storing a variable so that
     * its value can be referenced later and reused
     * @param variableName the name of the variable to be stored
     * @param value the value that this variable should be associated with
     * @return true if the variable was properly stored, false otherwise
     */
    public boolean createVariable(String variableName, double value);

    /**
     * delete a previously stored variable. the variable will no longer be able
     * to be referenced after this command
     * @param variableName the name of the variable to be deleted
     * @return true if the variable was propelry deleted, false otherwise
     */
    public boolean removeVariable(String variableName);
}