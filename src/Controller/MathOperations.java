package Controller;

public class MathOperations {
  public MathOperations(String... args){
  }

  public double sum(double expr1, double expr2){
    return expr1+expr2;
  }

  public double difference(double expr1, double expr2){
    return expr1-expr2;
  }

  public double product(double expr1, double expr2){
    return expr1*expr2;
  }

  public double quotient(double expr1, double expr2){
    return expr1/expr2;
  }

  public double remainder(double expr1, double expr2){
    return expr1%expr2;
  }

  public double minus(double expr1){
    return -expr1;
  }
  public double random(double maxValue){
    return Math.random()*maxValue;
  }
  public double sin(double degrees){
    return Math.sin(degrees);
  }
  public double cos(double degrees){
    return Math.cos(degrees);
  }
  public double tan(double degrees){
    return Math.tan(degrees);
  }
  public double atan(double degrees){
    return Math.atan(degrees);
  }
  public double log(double expr){
    return Math.log(expr);
  }
  public double pow(double base, double exponent){
    return Math.pow(base,exponent);
  }
  public double pi(){
    return PI;
  }
}
