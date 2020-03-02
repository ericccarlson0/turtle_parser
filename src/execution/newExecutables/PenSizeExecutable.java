package execution.newExecutables;

import execution.Executable;

public class PenSizeExecutable implements Executable {
    private double myPenSize;

    public PenSizeExecutable(double penSize) {
        myPenSize = penSize;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public Double[] getArgs() {
        return new Double[]{myPenSize};
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
