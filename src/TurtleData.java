public class TurtleData {
  public static final double DEFAULT_MIN_WIDTH = 2;
  public static final double DEFAULT_PEN_WIDTH = 4;

  private double xPos;
  private double yPos;
  private double heading;
  private double penWidth;
  private double minPenWidth;
  private boolean penDown;
  private boolean isShowing;
  private double[] color; // NOTE: will not be used if the turtle is an imported image.

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

  public double getX() {
    return xPos;
  }

  public double getY() {
    return yPos;
  }

  /**
   * A setter for the turtle's pen width that
   * @param width
   * @return
   */
  public double setPenWidth(double width) {
    double newWidth = (int) width; // because pixels can't be fractions
    if (width < minPenWidth) {
      newWidth = minPenWidth;
    }
    this.penWidth = newWidth;
    return newWidth;
  }
}
