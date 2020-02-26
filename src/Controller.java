

/*
import Visualizer.Visualizer;
import executables.Executable;
import java.util.ArrayList;
import parserModel.CommandParserNode;
import parserModel.TreeParser;
import javax.naming.Context;
import Visualizer.VisualContext;


public class Controller {
  private VisualContext myContext;
  private Visualizer myVisualizer;
  private TreeParser myTreeParser;


  public Controller(Visualizer vis) {
    myContext = new Context(vis, new ArrayList<>());
    myVisualizer = vis;
    myExecutableQueue = new ArrayList<>();
    myTreeParser = new TreeParser(myExecutableQueue);
  }



  public void step (String input) {
    CommandParserNode root = myTreeParser.parseString(input);
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
 */