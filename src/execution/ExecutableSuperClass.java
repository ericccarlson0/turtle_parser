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
  public static final String RESOURCES = "parserModel.languages.";
}

