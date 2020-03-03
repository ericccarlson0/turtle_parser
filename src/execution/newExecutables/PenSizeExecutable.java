package execution.newExecutables;

import execution.Executable;
import execution.ExecutableSuperClass;

public class PenSizeExecutable extends ExecutableSuperClass {
    private double myPenSize;

    public PenSizeExecutable(double penSize) {
        myPenSize = penSize;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public String getString() {
        return null;
    }

    @Override
    public String getExecutableName(String executableType) {
        return null;
    }
}
