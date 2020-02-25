package Visualizer;

import ParserModel.ParserNode;
import ParserModel.TreeParser;
import controller.Executables.Executable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.LinkedList;
import java.util.Queue;

public class Controller {
    private TreeParser myTreeParser;
    public Visualizer myVisualizer;
    private Timeline animation;

    public Controller () {
        myVisualizer = new Visualizer();
        myTreeParser = new TreeParser();
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
        testVisualizer();
    }


    public void step () {
        if(!myVisualizer.getCommand().equals("")) {
            ParserNode root = myTreeParser.parseString(myVisualizer.getCommand());
            myVisualizer.resetCommand();
            root.execute(); // adds execuables to the queue
        }
    }
    public Queue<Executable> getExeutableQueue(){
        Queue<Executable> x = new LinkedList<Executable>();
        return x;
    }
    // getTurtleX/Y, setTurtleX/Y, getIndex, setTurtleAngle, ...

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