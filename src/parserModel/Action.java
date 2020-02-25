package parserModel;

public interface Action {
    /**
     * Execute the action. This could involve multiple actions, to be taken on both the View and
     * the Model, such as FORWARD, LEFT, SETY, HEADING, PENUP, SHOW, etc.
     * @return A boolean indicating whether the Action was performed properly.
     */
    public abstract boolean execute();
}