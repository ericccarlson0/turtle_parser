package execution.newExecutables;

import execution.Executable;

public class SetPenColorExecutable implements Executable {
    private double myPenColor;

    public SetPenColorExecutable(double newPenColor) {
        myPenColor = newPenColor;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public Double[] getArgs() {
        return new Double[]{myPenColor};
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
