// Листинг 5.9 Quadratic.java — Приоритет операторов и горизонтальное разделение
//
// Выражения, которые концептуально связаны, должны быть разделены.
// Приоритет операторов должен быть ясен — используйте пробелы вокруг
// операторов для читаемости.
//

package fitnesse.wikitext.widgets;

public class Quadratic {

  public static double root1(double a, double b, double c) {
    double determinant = determinant(a, b, c);
    return (-b + Math.sqrt(determinant)) / (2*a);
  }

  public static double root2(int a, int b, int c) {
    double determinant = determinant(a, b, c);
    return (-b - Math.sqrt(determinant)) / (2*a);
  }

  private static double determinant(double a, double b, double c) {
    return b*b - 4*a*c;
  }
}
