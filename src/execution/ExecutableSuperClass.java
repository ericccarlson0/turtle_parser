package execution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
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
  private static final String RESOURCES = "parserModel.languages.";
  private static final int FULL_CIRCLE = 360;

  private final String languageChosen = ResourceBundle.getBundle("languages."+"LanguageChoice").getString("Language");

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
}

