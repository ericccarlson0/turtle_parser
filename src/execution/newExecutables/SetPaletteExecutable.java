package execution.newExecutables;

import execution.Executable;

public class SetPaletteExecutable implements Executable {
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
    public Double[] getArgs() {
        return new Double[]{myColorIndex, myRed, myGreen, myBlue};
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
