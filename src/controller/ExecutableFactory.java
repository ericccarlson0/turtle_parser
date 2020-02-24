package Controller;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.ResourceBundle;
import Controller.Executables.*;

public class ExecutableFactory {
  private static final String RESOURCES = "resources.languages.";
  private static final String LANGUAGE =  ResourceBundle.getBundle(RESOURCES + "LanguageChoice").getString("Language");
  private ResourceBundle commandLanguageResources;
  public ExecutableController makeExecutable(String execCommand){
    commandLanguageResources = ResourceBundle.getBundle(RESOURCES+LANGUAGE);
    String[] parsedCommand = execCommand.split(" ");
    String executableTypeInput = parsedCommand[0];
    String executableType = getPropertiesKey(executableTypeInput);
    Executable newExecutable = null;
    newExecutable = switch(executableType){
      case "Forward"     -> newExecutable = new forwardExecutable(parsedCommand[1]) ;  //Replace with properties call
      case "Backward"    -> newExecutable = new backExecutable(parsedCommand[1]) ;
      case "Left"        -> newExecutable = new leftExecutable(parsedCommand[1]) ;
      case "Right"       -> newExecutable = new rightExecutable(parsedCommand[1]) ;
      case "SetHeading"  -> newExecutable = new sethExecutable(parsedCommand[1]) ;
      case "SetTowards"  -> newExecutable = new towardsExecutable(parsedCommand[1]) ;
      case "SetPosition" -> newExecutable = new setxyExecutable(parsedCommand[1]) ;
      case "PenDown"     -> newExecutable = new pendownExecutable(parsedCommand[1]) ;
      case "PenUp"       -> newExecutable = new penupExecutable(parsedCommand[1]) ;
      case "ShowTurtle"  -> newExecutable = new showTurtleExecutable(parsedCommand[1]) ;
      case "HideTurtle"  -> newExecutable = new hideTurtleExecutable(parsedCommand[1]) ;
      case "Home"        -> newExecutable = new homeExecutable(parsedCommand[1]) ;
      case "ClearScreen" -> newExecutable = new clearExecutable(parsedCommand[1]) ;
    };
  return newExecutable;
  }
  private String getPropertiesKey(String commandInput){
    Enumeration<String> keys = commandLanguageResources.getKeys();
    while(keys.hasMoreElements()){
      String thisKey= keys.nextElement();
      String[] possibleCommands = commandLanguageResources.getString(thisKey).split("|");
      if(Arrays.asList(possibleCommands).contains(commandInput)){
        return thisKey;
      }


    }
    return "NOT A COMMAND";

  }
}
