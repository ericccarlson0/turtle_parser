package execution.newExecutables;

import execution.Executable;

public class SetShapeExecutable implements Executable {
    private double myShapeIndex;

    public SetShapeExecutable(double shapeIndex) {
        myShapeIndex = shapeIndex;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public Double[] getArgs() {
        return new Double[]{myShapeIndex};
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
