package controller;

public class BooleanOperations {
  public BooleanOperations(String... args){
  }

  public static boolean less(double expr1, double expr2){
    return expr1<expr2;
  }

  public static boolean greater(double expr1, double expr2){
    return expr1>expr2;
  }

  public static boolean equal(double expr1, double expr2){
    return expr1==expr2;
  }
  public static boolean notEqual(double expr1, double expr2){
    return expr1!=expr2;
  }

  public static boolean and(double test1, double test2){
    return (test1!=0 && test2!=0);
  }
  public static boolean or(double test1, double test2){
    return (test1!=0 || test2!=0);
  }

  public static boolean not(double test){
    return (test==0);
  }
}
