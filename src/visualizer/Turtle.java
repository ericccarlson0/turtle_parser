package visualizer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Turtle.java - a class to represent a turtle.
 * @author  Lorne Zhang
 * @version 1.0
 */
public class Turtle extends ImageView {
    private final static String TURTLE_FILE = "images/ball.jpg";
    private final static Image TURTLE_IMAGE = new Image(TURTLE_FILE);
    private static final int RIGHT_ANGLE = 90;
    private boolean pen = true;

    /**
     * Turtle() - constructor for the turtle.
     */
    public Turtle() {
        super(TURTLE_IMAGE);
        setAngle(0);
        setRotate(RIGHT_ANGLE);
    }

    public double getWidth(){
        return getBoundsInLocal().getWidth();
    }
    public double getHeight(){
        return getBoundsInLocal().getHeight();
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

    public boolean getPen(){
        return pen;
    }

    public void setAngle(double angle){
        setRotate(angle + RIGHT_ANGLE);
    }

    /**
     * setPen() - setter for the turtle's pen status.
     * @param pen turtle's pen status.
     */
    public void setPen(boolean pen) { this.pen = pen; }

}