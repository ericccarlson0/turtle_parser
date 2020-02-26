package execution;

import visualizer.Visualizer;
import java.util.ResourceBundle;

public abstract class Executable {
  public static final String RESOURCES = "parserModel.languages.";
  private final String languageChosen = ResourceBundle.getBundle("languages."+"LanguageChoice").getString("Language");

  public Executable(String... args){ }

  public abstract double run(Visualizer visualizerObject);

  public abstract String getString();

  protected String getExecutableName(String executableType){
    return ResourceBundle.getBundle(RESOURCES+languageChosen).getString(executableType).split("\\|")[0];

  }
}

