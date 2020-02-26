package execution;

import visualizer.Visualizer;
import java.util.ResourceBundle;

public abstract class ExecutableSuperClass implements Executable {
  public static final String RESOURCES = "parserModel.languages.";
  private final String languageChosen = ResourceBundle.getBundle("languages."+"LanguageChoice").getString("Language");

  public ExecutableSuperClass(String... args){ }

  @Override
  public String getExecutableName(String executableType){
    return ResourceBundle.getBundle(RESOURCES+languageChosen).getString(executableType).split("\\|")[0];

  }
}

