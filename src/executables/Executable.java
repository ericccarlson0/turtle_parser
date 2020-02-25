package executables;

import visualizer.Visualizer;
import java.util.ResourceBundle;

public abstract class Executable {
  private final String ""
  public Executable(String... args){ }

  public abstract double run(Visualizer visualizerObject);

  public abstract String getString();

  protected String getExecutableName(String executableType){
    private final String languageChosen = ResourceBundle.getBundle("b").getString("Language");
    private final String executableName = ResourceBundle.getBundle(""+languageChosen).getString("Bac");
  }
}

