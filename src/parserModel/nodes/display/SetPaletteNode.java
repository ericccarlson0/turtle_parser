package parserModel.nodes.display;

import execution.newExecutables.SetPaletteExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;

public class SetPaletteNode extends CommandParserNode {
    private ParserNode myIndex;
    private ParserNode myRed;
    private ParserNode myGreen;
    private ParserNode myBlue;
    @Override
    public void addNode(ParserNode node) {
        if(myIndex == null){
            myIndex = node;
        } else if (myRed == null){
            myRed = node;
        } else if (myGreen == null){
            myGreen = node;
        } else if (myBlue == null){
            myBlue = node;
        }
    }

    @Override
    public double execute(TurtleContext context) {
        double colorIndex = myIndex.execute(context);
        double red = myRed.execute(context);
        double green = myGreen.execute(context);
        double blue = myBlue.execute(context);
        context.getExecutableQueue().add(new SetPaletteExecutable(colorIndex,red, green, blue));
        return colorIndex;
    }

    @Override
    public boolean isComplete() {
        return myBlue != null;
    }
}
