// Листинг 9.8 — Тест, проверяющий более одной концепции
//
// Этот тест следовало бы разбить на три независимых теста, потому
// что в нем выполняются три независимых проверки.
// Объединение их в одной функции заставляет читателя гадать, почему
// в функцию включается каждая секция, и какое условие проверяется
// в этой секции.
//
// Проблема не в множественных директивах assert в разных секциях.
// Проблема в том, что тест проверяет более одной концепции.
//

public class SerialDateTest {

  /**
   * Тесты для метода addMonths().
   */
  public void testAddMonths() {
    SerialDate d1 = SerialDate.createInstance(31, 5, 2004);

    SerialDate d2 = SerialDate.addMonths(1, d1);
    assertEquals(30, d2.getDayOfMonth());
    assertEquals(6, d2.getMonth());
    assertEquals(2004, d2.getYYYY());

    SerialDate d3 = SerialDate.addMonths(2, d1);
    assertEquals(31, d3.getDayOfMonth());
    assertEquals(7, d3.getMonth());
    assertEquals(2004, d3.getYYYY());

    SerialDate d4 = SerialDate.addMonths(1, SerialDate.addMonths(1, d1));
    assertEquals(30, d4.getDayOfMonth());
    assertEquals(7, d4.getMonth());
    assertEquals(2004, d4.getYYYY());
  }
}

class SerialDate {
  static SerialDate createInstance(int day, int month, int year) { return new SerialDate(); }
  static SerialDate addMonths(int months, SerialDate date) { return new SerialDate(); }
  int getDayOfMonth() { return 0; }
  int getMonth() { return 0; }
  int getYYYY() { return 0; }
}
