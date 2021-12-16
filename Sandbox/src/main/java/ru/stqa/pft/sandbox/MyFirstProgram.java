package ru.stqa.pft.sandbox;



public class MyFirstProgram {

  public static void main(String[] args) {
    // hello("world");
    // hello("user");
    // hello("Renat");

//    Square s = new Square(5);

    //  System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    // Rectangle r = new Rectangle(4, 6);

    // System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());


// расчет растояния между 2 точками коордианат

    int n = 0;
    Point p1 = new Point(2, 3);
    //System.out.println("Координаты точки p1 = (" + p1.x + "," + p1.y + ")");

    Point p2 = new Point(5, 7);
    //System.out.println("Координаты точки p2 = (" + p2.x + "," + p2.y + ")");

    System.out.println("Формула расчета расстояния между точками на плоскости: Растояние = корень/(x1-x2)^2+(y1-y2)^2/");
    System.out.println("Расстояние между точками на плоскости = корень ( " + distance(p1, p2) * distance(p1, p2) + " + " + p1 + ") =" + distance(p1, p2));
    System.out.println("Расстояние между точками p1 и p2 = (" + p1 + "," + p2 + ")");
    System.out.println(p2.distance(p1));
    System.out.println(p1.distance(p2));
    // System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());
  }

  public static double distance(Point p1, Point p2) {
    double px = (p1.x - p2.x);
    //  System.out.println("dx^2= " + px*px);
    double py = (p1.y - p2.y);
    //  System.out.println("dy^2= " + py*py);

    //  System.out.println("D^2= " + (px * px + py * py));

    return Math.sqrt(px * px + py * py);

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

}

