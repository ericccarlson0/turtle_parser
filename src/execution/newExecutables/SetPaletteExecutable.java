package execution.newExecutables;

import execution.Executable;
import execution.ExecutableSuperClass;

public class SetPaletteExecutable extends ExecutableSuperClass {
    private double myColorIndex;
    private double myRed;
    private double myGreen;
    private double myBlue;

    public SetPaletteExecutable(double colorIndex, double red, double green, double blue) {
        myColorIndex = colorIndex;
        myRed = red;
        myGreen = green;
        myBlue = blue;
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
