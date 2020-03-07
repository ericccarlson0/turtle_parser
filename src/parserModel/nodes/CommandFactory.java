package parserModel.nodes;

import parserModel.TurtleContext;
import parserModel.exceptions.NoSuchCommandException;
import parserModel.exceptions.UnexpectedParsingException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * A class that abstracts the implementation of creating a Command Node using reflection
 */
public class CommandFactory {
    private static final String RESOURCE_PATH = "parserModel.nodes.CommandNodeReflection";
    private static final ResourceBundle commandNameResource = ResourceBundle.getBundle(RESOURCE_PATH);
    private static final String ROOT_NODE_PACKAGE = "parserModel.nodes.";
    /**
     * This is a huge case statement that turns 'identifier' strings into various instances of
     * ParserNode sub-classes
     * @param identifier    A particular string associated with a particular type of ParserNode.
     * @return              Returns subclass of ParserNode.
     */
    public ParserNode createCommand(String identifier, String textEntered, TurtleContext context) {
        try {
            String NodeClassPath = ROOT_NODE_PACKAGE + commandNameResource.getString(identifier);
            Constructor<?> constructor = Class.forName(NodeClassPath).getConstructor(String.class);
            return (ParserNode) constructor.newInstance(textEntered);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | MissingResourceException e) {
            throw new UnexpectedParsingException();
        } catch (ClassNotFoundException e) {
            return context.getData().getCommand(identifier);
        } catch(NoSuchCommandException e){
            return new WildCardToken(identifier);
        }
    }
}
