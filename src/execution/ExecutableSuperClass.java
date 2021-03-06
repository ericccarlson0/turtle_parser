package execution;

import java.util.ResourceBundle;

/**
 * @Author: Cemal Yagcioglu
 * This superclass represents the Executable command objects that result from parsing the user input.
 * It implements Executable Interface and offers some helper instance variables and methods or
 * subclasses that wants to use the standard structure.
 */
public abstract class ExecutableSuperClass implements Executable {
  public static final String RESOURCES = "parserModel.languages.";
  private String languageChoice = "LanguageChoice";

  /**
   * This is a helper method for subclasses' toString method, which returns the command's name in
   * the user's language.
   * @param executableType
   * @return The command's name in the user's language
   */
  protected String getExecutableName(String executableType){
    return ResourceBundle.getBundle(languageChoice).getString(executableType).split("\\|")[0];

  }

}
