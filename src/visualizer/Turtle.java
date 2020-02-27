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
    private double x_coordinate;
    private double y_coordinate;
    private double old_x_coordinate;
    private double old_y_coordinate;
    private double angle;
    private boolean pen = true;
    private int id;

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
     * @param image image for the turtle.
     * @param xPos turtle's x coordinate.
     * @param yPos turtle's y coordinate.
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

    /**
     * getAngle() - getter for the turtle's angle.
     * @return turtle's angle.
     */
    public double getAngle(){
        return angle;
    }

    /**
     * setXCoordinate() - setter for the turtle's x coordinate.
     * @param xPos turtle's x coordinate.
     */
    public void setXCoordinate(double xPos){
        old_x_coordinate = x_coordinate;
        this.x_coordinate = xPos - TURTLE_OFFSET;
        setX(xPos - TURTLE_OFFSET);
    }

    /**
     * setYCoordinate() - setter for the turtle's y coordinate.
     * @param yPos turtle's y coordinate.
     */
    public void setYCoordinate(double yPos){
        old_y_coordinate = y_coordinate;
        this.y_coordinate = yPos - TURTLE_OFFSET;
        setY(yPos - TURTLE_OFFSET);
    }

    /**
     * setXGameCoordinate() - setter for the turtle's screen x coordinate.
     * @param xPos turtle's screen x coordinate.
     */
    public void setXGameCoordinate(double xPos){
        old_x_coordinate = x_coordinate;
        this.x_coordinate = xPos - TURTLE_OFFSET + CENTER;
        setX(xPos - TURTLE_OFFSET + CENTER);
    }

    /**
     * setYGameCoordinate() - setter for the turtle's screen y coordinate.
     * @param yPos turtle's screen y coordinate.
     */
    public void setYGameCoordinate(double yPos){
        old_y_coordinate = y_coordinate;
        this.y_coordinate = FIELD_SIZE - (yPos + TURTLE_OFFSET + CENTER);
        setY(FIELD_SIZE - (yPos + TURTLE_OFFSET + CENTER));
    }

    /**
     * getXCoordinate() - getter for the turtle's x coordinate.
     * @return turtle's x coordinate.
     */
    public double getXCoordinate(){
        return x_coordinate + TURTLE_OFFSET;
    }

    /**
     * getYCoordinate() - getter for the turtle's y coordinate.
     * @return turtle's y coordinate.
     */
    public double getYCoordinate(){
        return y_coordinate + TURTLE_OFFSET;
    }

    /**
     * getXGameCoordinate() - getter for the turtle's screen x coordinate.
     * @return turtle's screen x coordinate.
     */
    public double getXGameCoordinate(){
        return x_coordinate + TURTLE_OFFSET - CENTER;
    }

    /**
     * getYGameCoordinate() - getter for the turtle's screen y coordinate.
     * @return turtle's screen y coordinate.
     */
    public double getYGameCoordinate(){
        return FIELD_SIZE - (y_coordinate + TURTLE_OFFSET - CENTER);
    }

    /**
     * getOldXCoordinate() - getter for the turtle's previous x coordinate.
     * @return turtle's previous x coordinate.
     */
    public double getOldXCoordinate(){
        return old_x_coordinate + TURTLE_OFFSET;
    }

    /**
     * getOldYCoordinate() - getter for the turtle's previous y coordinate.
     * @return turtle's previous y coordinate.
     */
    public double getOldYCoordinate(){
        return old_y_coordinate + TURTLE_OFFSET;
    }

    /**
     * setAngle() - setter for the turtle's angle.
     * @param angle turtle's angle.
     */
    public void setAngle(double angle){
        this.angle = angle;
        setRotate(angle + 90);
    }

    /**
     * getPen() - getter for the turtle's pen status.
     * @return turtle's pen status.
     */
    public boolean getPen() { return this.pen; }

    /**
     * setPen() - setter for the turtle's pen status.
     * @param pen turtle's pen status.
     */
    public void setPen(boolean pen) { this.pen = pen; }

}