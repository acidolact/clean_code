// Листинг 6.5 — Процедурные фигуры
//
// Класс Geometry работает с тремя классами геометрических фигур.
// Классы фигур представляют собой простые структуры данных,
// лишенные какого-либо поведения. Все поведение сосредоточено
// в классе Geometry.
//
// Это процедурный код — структуры данных + функции, работающие с ними.
// Добавление новой фигуры требует изменения всех функций Geometry.
//

public class Square {

  public Point topLeft;
  public double side;
}

public class Rectangle {

  public Point topLeft;
  public double height;
  public double width;
}

public class Circle {

  public Point center;
  public double radius;
}

public class Geometry {

  public final double PI = 3.141592653589793;

  public double area(Object shape) throws NoSuchShapeException {
    if (shape instanceof Square) {
      Square s = (Square)shape;
      return s.side * s.side;
    }
    else if (shape instanceof Rectangle) {
      Rectangle r = (Rectangle)shape;
      return r.height * r.width;
    }
    else if (shape instanceof Circle) {
      Circle c = (Circle)shape;
      return PI * c.radius * c.radius;
    }
    throw new NoSuchShapeException();
  }
}

class NoSuchShapeException extends Exception {}
