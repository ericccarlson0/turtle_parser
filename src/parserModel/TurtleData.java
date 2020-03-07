package parserModel;

import java.util.List;

/**
 * A class that encapuslates all of the data and behavior of a turtel. this is the
 * "model" in its purest sense, with the rest of the backend being mostly
 * concerned with aprsing
 *
 * @author Mariusz Derezinski-Choo
 */
public class TurtleData {
  public static final double DEFAULT_MIN_WIDTH = 2;
  public static final double DEFAULT_PEN_WIDTH = 4;
  public static final double ENVIRONMENT_SIZE = 650;
  private static final double DEGREES_TO_RADIANS = Math.PI / 180.0;
  private static final double RADIANS_TO_DEGREES = 1 / DEGREES_TO_RADIANS;

  private double xPos;
  private double yPos;
  private double heading;
  private double minPenWidth;
  private boolean penDown;
  private boolean isShowing;
  private double myPenColorIndex;
  /**
   * There are three constructors for the tree most common use cases.
   */
  public TurtleData() {
    this.xPos = 0;
    this.yPos = 0;
    this.heading = 0;
    this.minPenWidth = DEFAULT_MIN_WIDTH;
    this.penDown = true;
    this.isShowing = true;
  }
  public TurtleData(double x, double y) {
    this.xPos = x;
    this.yPos = y;
    this.heading = 0;
    this.minPenWidth = DEFAULT_MIN_WIDTH;
    this.penDown = true;
    this.isShowing = true;
  }
  public TurtleData(double x, double y, double heading) {
    this.xPos = x;
    this.yPos = y;
    this.heading = heading;
    this.minPenWidth = DEFAULT_MIN_WIDTH;
    this.penDown = true;
    this.isShowing = true;
  }

  /**
   * reset the locations back to their original location
   */
  public void clear() {
    xPos = 0;
    yPos = 0;
    heading = 0;
    minPenWidth = DEFAULT_PEN_WIDTH;
    penDown = true;
    isShowing = true;
  }

  /**
   * move the turtle back to the home position
   */
  public void home() {
    xPos = 0;
    yPos = 0;
  }

  /**
   * hide the turtle
   */
  public void hide() {
    isShowing = false;
  }

  /**
   * show the turtle on the screen
   */
  public void show() { isShowing = true; }

  /**
   * move the turtle forward
   * @param distance the distance to move forwar
   */
  public void forward(double distance) {
    double xDiff = distance*Math.cos(heading);
    double yDiff = distance*Math.sin(heading);
    xPos += xDiff;
    yPos += yDiff;
  }

  /**
   * query whether the turtle is showing
   * @return
   */
  public boolean isShowing(){
    return isShowing;
  }

  /**
   * move the turtle backward
   * @param distance the distance to move backward
   */
  public void backward(double distance) {
    forward(-1 * distance);
  }

  /**
   * set the x coordinate of the turtle
   * @param newXPos the new x coordinate to be setting
   */
  public void setX(double newXPos) { xPos = newXPos % ENVIRONMENT_SIZE; }

  /**
   * set the y coordinate of the turtle
   * @param newYPos the y coordinate to be setting
   */
  public void setY(double newYPos) { yPos = newYPos % ENVIRONMENT_SIZE; }

  /**
   * rotate the turtel clockwise
   * @param degrees the degrees to be rotating clockwise
   */
  public void turnClockwise(double degrees) {
    heading -= degrees * DEGREES_TO_RADIANS;
  }
  /**
   * rotate the turtel counterclockwise
   * @param degrees the degrees to be rotating counterclockwise
   */
  public void turnCounterClockwise(double degrees) {
    heading += degrees * DEGREES_TO_RADIANS;
  }

  /**
   * set the heading to a specific direction
   * @param degrees the heading in degrees to rotate to
   */
  public void setHeading(double degrees) { heading = (degrees % 360) * DEGREES_TO_RADIANS;}

  /**
   * set the pen down
   */
  public void penDown() { penDown = true; }

  /**
   * set the pen up
   */
  public void penUp() { penDown = false; }

  /**
   * set the pen color of the turtle
   * @param index the index of the pen color for the turtle
   */
  public void setPenColor(double index){
    myPenColorIndex = index;
  }

  /**
   * @return the x position of the turtle
   */
  public double getX() { return xPos; };

  /**
   * @return the y position of the turtle
   */
  public double getY() { return yPos; };

  /**
   * @return the heading of the turtle
   */
  public double getHeading() {
    return heading * RADIANS_TO_DEGREES;
  }

  /**
   * @return get a query of whether the pen is pointing down
   */
  public boolean getPenDown(){ return penDown;}

  /**
   * @return the index of the pen color
   */
  public double getPenColor(){
    return myPenColorIndex;
  }

  /**
   * query whether the pen is down
   * @return
   */
  private double penDownDouble() {
    if (penDown) {
      return 1.0;
    } else {
      return 0.0;
    }
  }

  public List<Double> getSummaryList() {
    return List.of(xPos, yPos, heading, penDownDouble());
  }

  /**
   * set the width of the turtle pen
   * @param width the weidth of the turtle pen
   * @return the new width
   */
  public double setPenWidth(double width) {
    double newWidth = (int) width; // because pixels can't be fractions
    if (width < minPenWidth) {
      newWidth = minPenWidth;
    }
    return newWidth;
  }

  /**
   * get the shape index of the turtle
   * @return
   */
  public double getShapeIndex(){
    return 0.0; //FIXME;
  }
}
