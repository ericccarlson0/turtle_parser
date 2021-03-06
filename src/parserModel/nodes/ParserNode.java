package parserModel.nodes;

import parserModel.TurtleContext;
import parserModel.nodes.leafNodes.VariableNode;

/**
 * Defines core functionality of a ParserNode, a Node that the parser can create and
 * add nodes to until it is complete (requires no more children), and then
 * can execute within some context to get a result
 *
 * @author Mariusz Derezinski-Choo
 */
public interface ParserNode {

    /**
     * add a child node to the current Node
     * @param node the child node to be added
     */
    void addNode(ParserNode node);

    /**
     * Add a variable to the current node to be used as a child
     * @param node the variable to be added
     */
    void addVariable(VariableNode node);

    /**
     * execute this Node
     * @param context the context within which this command should be executed
     * @return double the result of the execution
     */
    double execute(TurtleContext context);

    /**
     * check if the Node is complete (requires no more children)
     * @return a boolean denoting whether the Node is complete
     */
    boolean isComplete();
}
