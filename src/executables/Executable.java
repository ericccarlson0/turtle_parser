package executables;

import visualizer.Visualizer;
import java.util.ResourceBundle;

public abstract class Executable {
  public static final String RESOURCES = "parserModel.languages.";
  //private final String languageChosen = ResourceBundle.getBundle("Resources.Languages."+"LanguageChoice").getString("Language");
  private final String languageChosen = "English";

  public Executable(String... args){ }

  public abstract double run(Visualizer visualizerObject);

  public abstract String getString();

  protected String getExecutableName(String executableType){
    String x = ResourceBundle.getBundle(RESOURCES+languageChosen).getString(executableType);
    return x.substring(0,x.indexOf("|"));

  }
}

