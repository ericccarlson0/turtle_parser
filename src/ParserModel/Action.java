package ParserModel;

//To be implemented, just here so that the Java compiler doesn't complain
public interface Action {
    /**
     * execute the action. This could involve a number of actions to be taken on both the View and the Model
     * @return a boolean indicating whether the Action was performed properly
     */
    public boolean execute();
}
