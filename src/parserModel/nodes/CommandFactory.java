package parserModel.nodes;

import parserModel.TurtleContext;
import parserModel.exceptions.NoSuchCommandException;

import java.lang.reflect.Constructor;
import java.util.Iterator;
import java.util.ResourceBundle;


public class CommandFactory {
    private static final String RESOURCE_PATH = "parserModel.nodes.CommandNodeReflection";
    private static final ResourceBundle commandNameResource = ResourceBundle.getBundle(RESOURCE_PATH);
    /**
     * This is a huge case statement that turns 'identifier' strings into various instances of
     * ParserNode sub-classes
     * @param identifier    A particular string associated with a particular type of ParserNode.
     * @return              Returns subclass of ParserNode.
     */
    public ParserNode createCommand(String identifier, TurtleContext context) {
        //debug();
        if (commandNameResource.containsKey(identifier)) {
            try {
                System.out.println("the identifier is: " + identifier);
                String NodeClassPath = "parserModel.nodes."+ commandNameResource.getString(identifier);
                Constructor<?> constructor = Class.forName(NodeClassPath).getConstructor(String.class);
                return (ParserNode) constructor.newInstance(identifier);
            } catch (Exception e) {
                System.out.println("no identifier for : " + identifier);
                e.printStackTrace(); //TODO: return errorNode.
            }
        }
        try {
            return context.getData().getCommand(identifier);
        } catch (NoSuchCommandException e){
            return new WildCardToken(identifier);
        }
    }
    private void debug(){
        for (Iterator<String> it = commandNameResource.getKeys().asIterator(); it.hasNext(); ) {
            String test = it.next();
            try{
                System.out.println("testing " + test);
                String NodeClassPath = "parserModel.nodes."+ commandNameResource.getString(test);
                Constructor<?> constructor = Class.forName(NodeClassPath).getConstructor(String.class);
                constructor.newInstance(test);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
