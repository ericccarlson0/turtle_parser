package execution.newExecutables;

import execution.ExecutableSuperClass;

public class SetBackgroundExecutable extends ExecutableSuperClass {
    private double myIndex;

    public SetBackgroundExecutable(double index){
        myIndex = index;
    }

    @Override
    public String getCommand() {
        return null;
    }

    @Override
    public Double[] getArgs() {
        return new Double[]{myIndex};
    }

    @Override
    public String getString() {
        return null;
    }
}
