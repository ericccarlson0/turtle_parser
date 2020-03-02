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

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public Double[] getArgs() {
        return new Double[0];
    }

    /**
     * Returns the string value to be shown on the executable history.
     * @return Executable Name.
     */
    @Override
    public String getString() {
        return "";
    }
}
