// Листинг 7.6 — Не передавайте null
//
// Возвращать null из методов плохо, но передавать null при вызове
// еще хуже. По возможности избегайте передачи null в своем коде.
//
// Что произойдет, если при вызове будет передан аргумент null?
// Конечно, возникнет исключение NullPointerException.
//
// Как исправить? Можно создать новый тип исключения и инициировать
// его в методе, или воспользоваться assert.
//

public class MetricsCalculator {

  public double xProjection(Point p1, Point p2) {
    if (p1 == null || p2 == null) {
      throw InvalidArgumentException(
        "Invalid argument for MetricsCalculator.xProjection");
    }
    return (p2.x - p1.x) * 1.5;
  }
}

class InvalidArgumentException extends Exception {
  InvalidArgumentException(String message) {}
}

class Point {
  double x = 0;
  double y = 0;
}
