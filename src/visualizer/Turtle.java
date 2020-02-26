package visualizer;
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
    private final static int TURTLE_OFFSET = 20;
    private final static int CENTER = 250;
    private final static int SCREEN_SIZE = 700;
    private final static int FIELD_SIZE = 500;


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
        setAngle(0);
        setRotate(0);
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
        old_x_coordinate = xPos;
        old_y_coordinate = yPos;
        id = turtleIndex;
        setAngle(0);
        setRotate(90);
    }

    public double getAngle(){
        return angle;
    }

    public void setXCoordinate(double xPos){
        old_x_coordinate = x_coordinate;
        this.x_coordinate = xPos - TURTLE_OFFSET;
        setX(xPos - TURTLE_OFFSET);
    }

    public void setYCoordinate(double yPos){
        old_y_coordinate = y_coordinate;
        this.y_coordinate = yPos - TURTLE_OFFSET;
        setY(yPos - TURTLE_OFFSET);
    }

    public void setXGameCoordinate(double xPos){
        old_x_coordinate = x_coordinate;
        this.x_coordinate = xPos - TURTLE_OFFSET + CENTER;
        setX(xPos - TURTLE_OFFSET + CENTER);
    }

    public void setYGameCoordinate(double yPos){
        old_y_coordinate = y_coordinate;
        this.y_coordinate = FIELD_SIZE - (yPos + TURTLE_OFFSET + CENTER);
        setY(FIELD_SIZE - (yPos + TURTLE_OFFSET + CENTER));
    }

    public double getXCoordinate(){
        return x_coordinate + TURTLE_OFFSET;
    }

    public double getYCoordinate(){
        return y_coordinate + TURTLE_OFFSET;
    }

    public double getXGameCoordinate(){
        return x_coordinate + TURTLE_OFFSET - CENTER;
    }

    public double getYGameCoordinate(){
        return FIELD_SIZE - (y_coordinate + TURTLE_OFFSET - CENTER);
    }

    public double getOldXCoordinate(){
        return old_x_coordinate + TURTLE_OFFSET;
    }

    public double getOldYCoordinate(){
        return old_y_coordinate + TURTLE_OFFSET;
    }


    public void setAngle(double angle){
        this.angle = angle;
        setRotate(angle + 90);
    }

    public boolean getPen() { return this.pen; }

    public void setPen(boolean pen) { this.pen = pen; }

}