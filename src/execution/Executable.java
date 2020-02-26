package execution;

import visualizer.Visualizer;

public interface Executable {

  double run(Visualizer visualizerObject);

  String getString();

  String getExecutableName(String executableType);
}
