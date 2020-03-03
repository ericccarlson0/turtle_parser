package execution.newExecutables;

import execution.Executable;
import execution.ExecutableSuperClass;

public class SetShapeExecutable extends ExecutableSuperClass {
    private double myShapeIndex;

    public SetShapeExecutable(double shapeIndex) {
        myShapeIndex = shapeIndex;
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
