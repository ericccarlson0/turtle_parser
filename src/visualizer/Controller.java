package visualizer;

import executables.Executable;
import parserModel.ParserNode;
import parserModel.TreeParser;
//import controller.Executables.Executable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Controller {
    private TreeParser myTreeParser;
    public Visualizer myVisualizer;
    private Timeline animation;
    private List<Executable> executables;


    public Controller () {
        myVisualizer = new Visualizer();
        myVisualizer.setTurtlePen(true);
        executables = new ArrayList<>();
        myTreeParser = new TreeParser(executables);
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
        //testVisualizer();
    }


    public void step () {
        if(!myVisualizer.getCommand().equals("")) {
            ParserNode root = myTreeParser.parseString(myVisualizer.getCommand());
            myVisualizer.resetCommand();
            root.execute();
        }
        if(executables.size() != 0){
            executables.get(0).run(myVisualizer);
            executables.remove(0);
        }

    }



    private void testVisualizer(){
        for(int i=0; i<2000; i++){
            myVisualizer.setTurtleX(myVisualizer.getTurtleX()+ 1 * Math.cos(Math.toRadians(0))); // 1
            myVisualizer.setTurtleY(myVisualizer.getTurtleY()+ 1 * Math.sin(Math.toRadians(0))); // 0
            myVisualizer.draw();
        }
        for(int i=0; i<100; i++){
            myVisualizer.setTurtleX(myVisualizer.getTurtleX()+ 1 * Math.cos(Math.toRadians(90))); // 0
            myVisualizer.setTurtleY(myVisualizer.getTurtleY()+ 1 * Math.sin(Math.toRadians(90))); // 1
            myVisualizer.draw();
        }
        for(int i=0; i<100; i++){
            myVisualizer.setTurtleX(myVisualizer.getTurtleX()+ 1 * Math.cos(Math.toRadians(180))); // -1
            myVisualizer.setTurtleY(myVisualizer.getTurtleY()+ 1 * Math.sin(Math.toRadians(180))); // 0
            myVisualizer.draw();
        }
        for(int i=0; i<100; i++){
            myVisualizer.setTurtleX(myVisualizer.getTurtleX()+ 1 * Math.cos(Math.toRadians(270))); // 0
            myVisualizer.setTurtleY(myVisualizer.getTurtleY()+ 1 * Math.sin(Math.toRadians(270))); // -1
            myVisualizer.draw();
        }
        myVisualizer.setTurtlePen(false);
        for(int i=0; i<100; i++){
            myVisualizer.setTurtleX(myVisualizer.getTurtleX()+ 1 * Math.cos(Math.toRadians(45)));
            myVisualizer.setTurtleY(myVisualizer.getTurtleY()+ 1 * Math.sin(Math.toRadians(45)));
            myVisualizer.draw();
        }
        myVisualizer.setTurtlePen(true);
        for(int i=0; i<1000; i++){
            myVisualizer.setTurtleX(myVisualizer.getTurtleX()+ 1 * Math.cos(Math.toRadians(45)));
            myVisualizer.setTurtleY(myVisualizer.getTurtleY()+ 1 * Math.sin(Math.toRadians(45)));
            myVisualizer.draw();
        }
    }
}