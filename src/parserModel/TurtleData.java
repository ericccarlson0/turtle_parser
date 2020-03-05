package parserModel;

import java.util.List;

public class TurtleData {
  public static final double DEFAULT_MIN_WIDTH = 2;
  public static final double DEFAULT_PEN_WIDTH = 4;
  public static final double ENVIRONMENT_SIZE = 650;

  private double xPos;
  private double yPos;
  private double heading;
  private double penWidth;
  private double minPenWidth;
  private boolean penDown;
  private boolean isShowing;
  private double[] color; // NOTE: will not be used if the turtle is an imported image.
  private double myPenColorIndex;

  /**
   * There are three constructors for the tree most common use cases.
   */
  public TurtleData() {
    this.xPos = 0;
    this.yPos = 0;
    this.heading = 0;
    this.minPenWidth = DEFAULT_MIN_WIDTH;
    this.penWidth = DEFAULT_PEN_WIDTH;
    this.penDown = true;
    this.isShowing = true;
    this.color = new double[]{0, 0, 0};
  }
  public TurtleData(double x, double y) {
    this.xPos = x;
    this.yPos = y;
    this.heading = 0;
    this.minPenWidth = DEFAULT_MIN_WIDTH;
    this.penWidth = DEFAULT_PEN_WIDTH;
    this.penDown = true;
    this.isShowing = true;
    this.color = new double[]{0, 0, 0};
  }
  public TurtleData(double x, double y, double heading) {
    this.xPos = x;
    this.yPos = y;
    this.heading = heading;
    this.minPenWidth = DEFAULT_MIN_WIDTH;
    this.penWidth = DEFAULT_PEN_WIDTH;
    this.penDown = true;
    this.isShowing = true;
    this.color = new double[]{0, 0, 0};
  }

  public void clear() {
    xPos = 0;
    yPos = 0;
    heading = 0;
    minPenWidth = DEFAULT_PEN_WIDTH;
    penWidth = DEFAULT_PEN_WIDTH;
    penDown = true;
    isShowing = true;
    color = new double[]{0, 0, 0};
  }
  public void home() {
    xPos = 0;
    yPos = 0;
  }
  public void hide() {
    isShowing = false;
  }
  public void show() { isShowing = true; }
  public void forward(double distance) {
    double xDiff = distance*Math.cos(heading);
    double yDiff = distance*Math.sin(heading);
    xPos += xDiff;
    yPos += yDiff;
  }
  public void backward(double distance) {
    forward(-1 * distance);
  }
  public void setX(double newXPos) { xPos = newXPos % ENVIRONMENT_SIZE; }
  public void setY(double newYPos) { yPos = newYPos % ENVIRONMENT_SIZE; }
  public void turnClockwise(double degrees) {
    heading -= degrees * Math.PI/180;
  }
  public void turnCounterClockwise(double degrees) {
    heading += degrees * Math.PI/180;
  }
  public void setHeading(double degrees) { heading = 360 % degrees; }
  public void penDown() { penDown = true; }
  public void penUp() { penDown = true; }
  public void setPenColor(double index){
    myPenColorIndex = index;
  }

  public double getX() { return xPos; };
  public double getY() { return yPos; };
  public double getHeading() {
    return heading * 180.0 / Math.PI;
  }
  public boolean getPenDown(){ return penDown;}
  public double getPenColor(){
    return myPenColorIndex;
  }

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

  public double setPenWidth(double width) {
    double newWidth = (int) width; // because pixels can't be fractions
    if (width < minPenWidth) {
      newWidth = minPenWidth;
    }
    this.penWidth = newWidth;
    return newWidth;
  }
}
