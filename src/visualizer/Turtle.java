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
    private final static int FIELD_SIZE = 500;
    private static final int RIGHT_ANGLE = 90;
    private double x_coordinate;
    private double y_coordinate;
    private double old_x_coordinate;
    private double old_y_coordinate;
    private double angle;
    private boolean pen = true;

    /**
     * Turtle() - constructor for the turtle.
     */
    public Turtle() {
        super(TURTLE_IMAGE);
        setAngle(0);
        setRotate(0);
    }

    /**
     * Turtle() - constructor for the turtle using image, x position, and y position.
     * @param image image for the turtle.
     */
    public Turtle(Image image, int turtleIndex) {
        super(image);
        setAngle(0);
        setRotate(RIGHT_ANGLE);
    }



    public void setAngle(double angle){
        this.angle = angle;
        setRotate(angle + RIGHT_ANGLE);
    }

    /**
     * setPen() - setter for the turtle's pen status.
     * @param pen turtle's pen status.
     */
    public void setPen(boolean pen) { this.pen = pen; }

}