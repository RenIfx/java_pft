package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Renat");

    Square s = new Square(5);

    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);

    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());






    Point p1 = new Point(2, 3);
    System.out.println("Координаты точки p1 = (" + p1.x + "," + p1.y + ")");

    Point p2 = new Point(5, 7);
    System.out.println("Координаты точки p2 = (" + p2.x + "," + p2.y + ")");



    double px = (p1.x- p2.x);
    double py = (p1.y- p2.y);
    double d = Math.sqrt(px*px+py*py);
    System.out.println("D = корень/(x1-x2)^2+(y1-y2)^2/" + " D = корень ( " + px*px + " + " + py*py + ") =" + d);
    System.out.println("Расстояние между точками p1 и p2 = (" + p2.x + "," + p2.y + ")");
    System.out.println(d);
  }


  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}