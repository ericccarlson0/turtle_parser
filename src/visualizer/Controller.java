package visualizer;

import execution.ExecutableSuperClass;
import parserModel.nodes.ParserNode;
import parserModel.TreeParser;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private VisualContext myContext;
    private TreeParser myTreeParser;
    public Visualizer myVisualizer;
    private Timeline animation;
    private List<ExecutableSuperClass> executables;

    public Controller () {
        myTreeParser = new TreeParser(executables);
        myVisualizer = new Visualizer();
        myVisualizer.setVariableList(myTreeParser.observableVariables());
        myVisualizer.setCommandList(myTreeParser.observableCommands());
        executables = new ArrayList<>();
        myContext = new VisualContext(myVisualizer, executables);
        start();
    }

    private void start() {
        KeyFrame frame = new KeyFrame(Duration.millis(10), e -> {
            step();
        });
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    private void step () {
        if(!myVisualizer.getCommand().equals("")) {
            double result = myTreeParser.parseString(myVisualizer.getCommand(), myContext);
            myVisualizer.resetCommand();
            //root.execute(myContext);
        }
        if(executables.size() != 0){
            executables.get(0).run(myVisualizer);
            myVisualizer.addExecutedHistory(executables.get(0).getString());
            executables.remove(0);
        }
    }
}