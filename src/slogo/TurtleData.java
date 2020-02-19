package slogo;

public class TurtleData {
  private double xPos;
  private double yPos;
  private double heading;
  private double width;
  private boolean penUp;
  private boolean isShowing;
  private double[] color; // the RGB color
  public TurtleData() { }
  public TurtleData(double x, double y) {
    this.xPos = x;
    this.yPos = y;
  }
  public TurtleData(double x, double y, double heading) {
    this.xPos = x;
    this.yPos = y;
    this.heading = heading;
  }
}
