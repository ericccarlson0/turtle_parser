package execution;

import visualizer.Visualizer;

/**
 * This subclass creates the executable command
 * object for Error reporting.
 */
public class ErrorReportingExecutable extends ExecutableSuperClass {
    private String myErrorMessage;

    /**
     * Constructs the executable.
     * @param error
     */
    public ErrorReportingExecutable(String error){
        myErrorMessage = error;
    }

    /**
     * Runs the executable.
     * @param visualizerObject
     * @return 0.
     */
    @Override
    public void execute(Visualizer visualizerObject) {
        visualizerObject.printToTerminal(myErrorMessage);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {

    }
}

