package parserModel.nodes.display;

import execution.newExecutables.SetPaletteExecutable;
import parserModel.TurtleContext;
import parserModel.nodes.ParserNode;
import parserModel.nodes.leafNodes.VariableNode;

public class SetPaletteNode implements ParserNode {
    private ParserNode myIndex;
    private ParserNode myRed;
    private ParserNode myGreen;
    private ParserNode myBlue;

    public SetPaletteNode(){
        myIndex = null;
        myRed = null;
        myGreen = null;
        myBlue = null;
    }

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
    public void addVariable(VariableNode node) {

    }

    @Override
    public double execute(TurtleContext context) {
        double colorIndex = myIndex.execute(context);
        double red = myRed.execute(context);
        double green = myGreen.execute(context);
        double blue = myBlue.execute(context);
        context.addToQueue(new SetPaletteExecutable(colorIndex,red, green, blue));
        return colorIndex;
    }

    @Override
    public boolean isComplete() {
        return myBlue != null;
    }
}
