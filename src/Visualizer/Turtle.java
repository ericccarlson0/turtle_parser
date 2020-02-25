package Visualizer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Turtle.java - a class to represent a turtle.
 * @author  Lorne Zhang
 * @version 1.0
 */
public class Turtle extends ImageView{
    private final static String TURTLE_FILE = "images/ball.jpg";
    private final static Image TURTLE_IMAGE = new Image(TURTLE_FILE);
    private double x_coordinate;
    private double y_coordinate;
    private double old_x_coordinate;
    private double old_y_coordinate;
    //private double xPosTarget;
    //private double yPosTarget;
    private double angle;
    private boolean pen = true;
    private int id;
    //private Queue<Double> xValues = new LinkedList<Double>();
    //private Queue<Double> yValues = new LinkedList<Double>();


    /**
     * Turtle() - constructor for the turtle.
     */
    public Turtle() {
        super(TURTLE_IMAGE);
        setXCoordinate(0);
        setYCoordinate(0);
        id = 0;
    }

    /**
     * Turtle() - constructor for the turtle using image, x position, and y position.
     * @param image
     * @param xPos
     * @param yPos
     */
    public Turtle(Image image, int xPos, int yPos, int turtleIndex) {
        super(image);
        setXCoordinate(xPos);
        setYCoordinate(yPos);
        old_x_coordinate = getXCoordinate();
        old_y_coordinate = getYCoordinate();
        id = turtleIndex;
    }
    /**
    public double getNextX(){
        if(xValues.size() != 0){
            return xValues.peek();
        }
        return xPos;
    }
    public void setxPosTarget(double x){
        xPosTarget = x;
    }
    public void setyPosTarget(double y){
        yPosTarget = y;
    }
    public double getNextY(){
        if(yValues.size() != 0){
            return yValues.peek();
        }
        return yPos;
    }
    public double getCurrentY(){
        return yPos;
    }
    public double getCurrentX(){
        return xPos;
    }

    public double getxPosTarget(){
        return xPosTarget;
    }
    public double getyPosTarget(){
        return yPosTarget;
    }

    public double getxPos(){
        if(xValues.size() != 0){
            double x = xValues.remove();
            xPos = x;
            return x;
        }
        return xPos;
    }

    public double getyPos(){
        if(yValues.size() != 0){
            double y = yValues.remove();
            yPos = y;
            return y;
        }
        return yPos;
    }
    */
    public double getAngle(){
        return angle;
    }

    public void setXCoordinate(double xPos){
        old_x_coordinate = x_coordinate;
        this.x_coordinate = xPos;
        setX(xPos);
    }

    public void setYCoordinate(double yPos){
        old_y_coordinate = y_coordinate;
        this.y_coordinate = yPos;
        setY(yPos);
    }

    public double getXCoordinate(){
        return x_coordinate;
    }

    public double getYCoordinate(){
        return y_coordinate;
    }
    public double getOldXCoordinate(){
        return old_x_coordinate;
    }

    public double getOldYCoordinate(){
        return old_y_coordinate;
    }


    public void setAngle(double angle){
        this.angle = angle;
    }

    public boolean getPen() { return this.pen; }

    public void setPen(boolean pen) { this.pen = pen; }

    /**
    public void addxPos(double xPos){
        xValues.add(xPos);
        xPosTarget = xPos;
        System.out.println(xValues.size());
    }

    public void addyPos(double yPos){
        yValues.add(yPos);
        yPosTarget = yPos;

    }
     */

}