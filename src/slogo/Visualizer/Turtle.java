package slogo.Visualizer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Turtle.java - a class to represent a turtle.
 * @author  Lorne Zhang
 * @version 1.0
 */
public class Turtle extends ImageView{
    private final static String TURTLE_FILE = "images/ball.jpg";
    private final static Image TURTLE_IMAGE = new Image(TURTLE_FILE);
    private double xPos;
    private double yPos;
    private double angle;
    private boolean pen;
    private int id;

    /**
     * Turtle() - constructor for the turtle.
     */
    public Turtle() {
        super(TURTLE_IMAGE);
        setxPos(0);
        setyPos(0);
        setX(0);
        setY(0);
    }

    /**
     * Turtle() - constructor for the turtle using image, x position, and y position.
     * @param image
     * @param xPos
     * @param yPos
     */
    public Turtle(Image image, int xPos, int yPos) {
        super(image);
        //setxPos(xPos);
        //setyPos(yPos);
        setX(xPos);
        setY(yPos);
    }

    public double getxPos(){
        return xPos;
    }


    public double getyPos(){
        return yPos;
    }

    public double getAngle(){
        return angle;
    }

    public void setxPos(double xPos){
        this.xPos = xPos;
    }

    public void setyPos(double yPos){
        this.yPos = yPos;
    }

    public void setAngle(double angle){
        this.angle = angle;
    }
}