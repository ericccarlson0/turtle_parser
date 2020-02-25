import Visualizer.Visualizer;
import executables.Executable;
import java.util.ArrayList;
import java.util.List;
import parserModel.ParserNode;
import parserModel.TreeParser;

public class Controller {
  private Visualizer myVisualizer;
  private TreeParser myTreeParser;
  private List<Executable> myExecutableQueue;

  public Controller(Visualizer vis) {
    myVisualizer = vis;
    myExecutableQueue = new ArrayList<>();
    myTreeParser = new TreeParser(myExecutableQueue);
  }

  public void step (String input) {
    ParserNode root = myTreeParser.parseString(input);
    root.execute(); // ***
    for (Executable e : myExecutableQueue) {
      e.run(myVisualizer);
    }

      // Now, we should have a tree-like structure that was created by myTreeParser and added to the
      // History.
      // When root.execute() was called, all of the appropriate Executioner objects should
      // have been added to myExecutableQueue.

  }
}