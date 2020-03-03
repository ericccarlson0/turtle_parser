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
    public String getString() {
        return null;
    }
}
