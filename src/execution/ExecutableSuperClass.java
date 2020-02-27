package execution;

import visualizer.Visualizer;
import java.util.ResourceBundle;

/**
 * @Author: Cemal Yagcioglu
 * This superclass offers implementation of
 * Executable command objects that result from parsing
 * the user input. It implements Executable Interface
 * and offers some helper instance variables and methods
 * for subclasses that wants to implement a similar structure.
 */
public abstract class ExecutableSuperClass implements Executable {
  public static final String RESOURCES = "parserModel.languages.";
  private final String languageChosen = ResourceBundle.getBundle("languages."+"LanguageChoice").getString("Language");

  /**
   * A structure for initiating the Executable subclasses.
   * @param args
   */
  public ExecutableSuperClass(String... args){ }

  /**
   * This is an helper method for subclasses' toString method,
   * and returns the command's name in the user's language.
   * @param executableType
   * @return The command's name in the user's language
   */
  @Override
  public String getExecutableName(String executableType){
    return ResourceBundle.getBundle(RESOURCES+languageChosen).getString(executableType).split("\\|")[0];

  }
}

