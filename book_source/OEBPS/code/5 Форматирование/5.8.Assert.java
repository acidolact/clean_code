// Листинг 5.8 Assert.java — Концептуальное родство
//
// Функции, которые концептуально связаны, должны располагаться рядом.
// assertTrue и assertFalse — пара, их порядок логичен.
//

package fitnesse.wikitext.widgets;

public class Assert {

  static public void assertTrue(String message, boolean condition) {
    if (!condition)
      fail(message);
  }

  static public void assertTrue(boolean condition) {
    assertTrue(null, condition);
  }

  static public void assertFalse(String message, boolean condition) {
    assertTrue(message, !condition);
  }

  static public void assertFalse(boolean condition) {
    assertFalse(null, condition);
  }

  private static void fail(String message) {}
}
