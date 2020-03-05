package execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @Author: Cemal Yagcioglu
 * This superclass represents the Executable command objects that result from parsing the user input.
 * It implements Executable Interface and offers some helper instance variables and methods or
 * subclasses that wants to use the standard structure.
 */
public abstract class ExecutableSuperClass implements Executable {
  public static final String RESOURCES = "parserModel.languages.";
  private String languageChoice = ResourceBundle.getBundle("languages.LanguageChoice").getString("Language");
// public static final int FULL_CIRCLE = 360;

  protected Collection<List<Double>> myArgs;
  protected int argSize;

  public ExecutableSuperClass(){
    myArgs = new ArrayList<>();
  }

  @Override
  public Collection<List<Double>> getArgs() {
    return new ArrayList<>(myArgs);
  }

  @Override
  public void addArg(List<Double> arg) {
    myArgs.add(arg);
  }

  @Override
  public int argSize() {
    return argSize;
  }

  /**
   * This is a helper method for subclasses' toString method, which returns the command's name in
   * the user's language.
   * @param executableType
   * @return The command's name in the user's language
   */
  @Override
  public String getExecutableName(String executableType){
    return ResourceBundle.getBundle(RESOURCES+languageChoice).getString(executableType).split("\\|")[0];
  }
}

