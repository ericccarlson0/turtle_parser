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
    private List<ExecutableSuperClass> executableSuperClasses;

    public Controller () {
        myTreeParser = new TreeParser(executableSuperClasses);
        myVisualizer = new Visualizer();
        myVisualizer.setVariableList(myTreeParser.observableVariables());
        myVisualizer.setCommandList(myTreeParser.observableCommands());
        executableSuperClasses = new ArrayList<>();
        myContext = new VisualContext(myVisualizer, executableSuperClasses);
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
            ParserNode root = myTreeParser.parseString(myVisualizer.getCommand());
            myVisualizer.resetCommand();
            root.execute(myContext);
        }
        if(executableSuperClasses.size() != 0){
            executableSuperClasses.get(0).run(myVisualizer);
            myVisualizer.addExecutedHistory(executableSuperClasses.get(0).getString());
            executableSuperClasses.remove(0);
        }
    }
}