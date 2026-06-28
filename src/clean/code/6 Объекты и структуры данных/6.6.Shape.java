// Листинг 6.6 — Полиморфные фигуры
//
// Метод area() является полиморфным, класс Geometry становится лишним.
// Добавление новой фигуры не затрагивает ни одну из существующих функций,
// но при добавлении новой функции приходится изменять все фигуры!
//
// Это объектно-ориентированный код — объекты скрывают данные и
// предоставляют поведение.
//

public interface Shape {
  double area();
}

public class Square implements Shape {

  private Point topLeft;
  private double side;

  public double area() {
    return side * side;
  }
}

public class Rectangle implements Shape {

  private Point topLeft;
  private double height;
  private double width;

  public double area() {
    return height * width;
  }
}

public class Circle implements Shape {

  private Point center;
  private double radius;
  public final double PI = 3.141592653589793;

  public double area() {
    return PI * radius * radius;
  }
}
