package visualizer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Turtle.java - a class to represent a turtle.
 * @author  Lorne Zhang
 * @version 1.0
 */
public class Turtle extends ImageView {
    private static final String DEFAULT_FILE = "images/turtle.jpg";
    private static final Image DEFAULT_IMAGE = new Image(DEFAULT_FILE);
    private static final int RIGHT_ANGLE = 90;
    private boolean penDown = true;

    /**
     * Turtle() - constructor for the turtle.
     */
    public Turtle() {
        super(DEFAULT_IMAGE);
        setAngle(0); setRotate(RIGHT_ANGLE);
    }

    public double getWidth(){
        return getBoundsInLocal().getWidth();
    }
    public double getHeight(){ return getBoundsInLocal().getHeight(); }
    public boolean getPenDown(){
        return penDown;
    }

    /**
     * Turtle() - constructor for the turtle using image, x position, and y position.
     * @param image image for the turtle.
     */
    public Turtle(Image image) {
        super(image);
        setAngle(0); setRotate(RIGHT_ANGLE);
    }

    /**
     * setPenDown() - setter for the turtle's pen status.
     * @param penDown turtle's pen status.
     */
    public void setPenDown(boolean penDown) { this.penDown = penDown; }

    public void setAngle(double angle){
        setRotate(angle + RIGHT_ANGLE);
    }
}