package parserModel.nodes;

import parserModel.TurtleContext;

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

    /**
     * return the type of Node
     * @return the type of Node
     */
    NodeType typeOfNode();
}
