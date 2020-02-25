package executables;

import Visualizer.Visualizer;
import java.util.ResourceBundle;

public abstract class Executable {
  public static final String RESOURCES = "Resources.Languages.";
  private final String languageChosen = ResourceBundle.getBundle(RESOURCES+"LanguageChoice").getString("Language");
  public static final String DEFAULT_RESOURCE_PACKAGE = RESOURCES + ".";
  public Executable(String... args){ }

  public abstract double run(Visualizer visualizerObject);

  public abstract String getString();

  protected String getExecutableName(String executableType){
    return ResourceBundle.getBundle(RESOURCES+languageChosen).getString(executableType).split("|")[0];
  }
}

