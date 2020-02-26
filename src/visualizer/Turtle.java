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
        old_x_coordinate = xPos - 16;
        old_y_coordinate = yPos - 16;
        id = turtleIndex;
        setAngle(0);
        setRotate(90);
    }

    public double getAngle(){
        return angle;
    }

    public void setXCoordinate(double xPos){
        old_x_coordinate = x_coordinate;
        this.x_coordinate = xPos - 16;
        setX(xPos - 16);
    }

    public void setYCoordinate(double yPos){
        old_y_coordinate = y_coordinate;
        this.y_coordinate = yPos - 16;
        setY(yPos - 16);
    }

    public void setXGameCoordinate(double xPos){
        this.x_coordinate = xPos - 16 + 350;
        setX(xPos - 16 + 350);
    }

    public void setYGameCoordinate(double yPos){
        this.y_coordinate = 675 - (yPos - 16 + 350);
        setY(675 - (yPos - 16 + 350));
    }

    public double getXCoordinate(){
        return x_coordinate + 16;
    }

    public double getYCoordinate(){
        return y_coordinate + 16;
    }

    public double getXGameCoordinate(){
        return x_coordinate + 16 - 350;
    }

    public double getYGameCoordinate(){
        return 700 - (y_coordinate + 16 - 350);
    }

    public double getOldXCoordinate(){
        return old_x_coordinate + 16;
    }

    public double getOldYCoordinate(){
        return old_y_coordinate + 16;
    }


    public void setAngle(double angle){
        this.angle = angle;
        setRotate(angle + 90);
    }

    public boolean getPen() { return this.pen; }

    public void setPen(boolean pen) { this.pen = pen; }
//
//    public void addxPos(double xPos){
//        xValues.add(xPos);
//        xPosTarget = xPos;
//        System.out.println(xValues.size());
//    }
//
//    public void addyPos(double yPos){
//        yValues.add(yPos);
//        yPosTarget = yPos;
//
//    }
}