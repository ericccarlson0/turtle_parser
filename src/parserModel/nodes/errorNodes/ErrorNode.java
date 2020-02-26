package parserModel.nodes.errorNodes;

import execution.ErrorReportingExecutable;
import parserModel.nodes.CommandParserNode;
import parserModel.nodes.ParserNode;
import visualizer.VisualContext;

public class ErrorNode extends CommandParserNode {
    private String myError;

    public ErrorNode(String error){
        myError = error;
    }

    @Override
    public void addNode(ParserNode node) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double execute(VisualContext context) {
        context.getExecutableQueue().add(new ErrorReportingExecutable(myError));
        return 0;
    }

    @Override
    public boolean isComplete() {
        return true;
    }
}
