package ru.stqa.pft.sandbox;

public class Point {

  public double x;
  public double y;
  static int n;




  public Point (double x, double y) {
    this.x = x;
    this.y = y;
    n++;
    System.out.println("Координаты точки p" +n +" = (" + x + "," + y + ")");

  }
  public double distance(Point p2){
    return Math.sqrt((this.x-p2.x)*(this.x-p2.x)+(this.y-p2.y)*(this.y-p2.y));

  }
  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public String toString() {
    return "Point{" + "x=" + x + ", y=" + y + '}';
  }

}
