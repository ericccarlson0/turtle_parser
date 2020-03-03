package execution.newExecutables;

import execution.Executable;
import execution.ExecutableSuperClass;

public class SetPenColorExecutable extends ExecutableSuperClass {
    private double myPenColor;

    public SetPenColorExecutable(double newPenColor) {
        myPenColor = newPenColor;
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
