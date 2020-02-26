package execution;

import visualizer.Visualizer;

public class ErrorReportingExecutable extends Executable{
    private String myErrorMessage;

    public ErrorReportingExecutable(String error){
        myErrorMessage = error;
    }

    @Override
    public double run(Visualizer visualizerObject) {
        visualizerObject.addUserInput(myErrorMessage);
        return 0;
    }

    @Override
    public String getString() {
        return "";
    }
}
