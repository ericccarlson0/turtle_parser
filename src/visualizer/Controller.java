package visualizer;

import execution.Executable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import parserModel.TreeParser;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import parserModel.TurtleContext;
import parserModel.exceptions.ParsingException;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Controller {
    private TreeParser myTreeParser;
    private Visualizer myVisualizer;
    private List<Executable> history;
    private List<Executable> executables;



    public Controller () {
        myTreeParser = new TreeParser();
        myVisualizer = new Visualizer();
        myVisualizer.setVariableList(myTreeParser.observableVariables());
        myVisualizer.setCommandList(myTreeParser.observableCommands());
        myVisualizer.setLanguageOptions(myTreeParser.getLanguageOptions());
        myVisualizer.getLanguageProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                myTreeParser.setLanguage(newValue);
            }
        });
        executables = new ArrayList<>();
        history = new ArrayList<>();
        start();
    }

    private void start() {
        KeyFrame frame = new KeyFrame(Duration.millis(10), e -> { step(); });
        Timeline animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(frame);
        animation.play();
    }

    private void step () {
        if (!myVisualizer.getCommand().equals("")) {
            try {
                Iterator<Executable> newCommands = myTreeParser.parseString(myVisualizer.getCommand());
                while(newCommands.hasNext()){
                    try {
                        Executable nextExecutable = newCommands.next();
                        nextExecutable.execute(myVisualizer);
                        myVisualizer.addExecutedHistory(nextExecutable.toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (ParsingException e) { }
            myVisualizer.run();
            myVisualizer.resetCommand();
        }
    }
}