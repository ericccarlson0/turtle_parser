package parserModel.nodes.parentNodes.multiOperation;

import execution.SetPaletteExecutable;
import parserModel.TurtleContext;
import parserModel.exceptions.InvalidGroupingException;
import parserModel.nodes.ParserNode;

import java.util.Iterator;

public class SetPaletteNode extends MultiOperandNode {

    public SetPaletteNode(String text) {
        super(text, 4);
    }

    @Override
    protected double runValidated(TurtleContext context) {
        SetPaletteExecutable executable = new SetPaletteExecutable();
        Iterator<ParserNode> iterator = arguments.iterator();
        int id = 0;
        while(iterator.hasNext()){
            id = (int)iterator.next().execute(context);
            double red = iterator.next().execute(context);
            double green = iterator.next().execute(context);
            double blue = iterator.next().execute(context);
            executable.addMove(id, red, green, blue);
        }
        return id;
    }

    @Override
    protected void validateArguments() {
        if(arguments.size() % 4 != 0){
            throw new InvalidGroupingException(this.toString(), "arguments must be multiples of 4!");
        }
    }
}
