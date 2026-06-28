// Листинг 9.7 SerializedPageResponderTest.java — Одна директива assert
//
// Тест можно разбить на два отдельных теста, каждый из которых
// имеет собственную директиву assert.
// Обратите внимание: я переименовал функции в соответствии со
// стандартной схемой given-when-then [RSpec]. Это еще сильнее
// упрощает reading тестов.
//

public class SerializedPageResponderTest {

  public void testGetPageHierarchyAsXml() throws Exception {
    givenPages("PageOne", "PageOne.ChildOne", "PageTwo");

    whenRequestIsIssued("root", "type:pages");

    thenResponseShouldBeXML();
  }

  public void testGetPageHierarchyHasRightTags() throws Exception {
    givenPages("PageOne", "PageOne.ChildOne", "PageTwo");

    whenRequestIsIssued("root", "type:pages");

    thenResponseShouldContain(
      "<name>PageOne</name>", "<name>PageTwo</name>", "<name>ChildOne</name>");
  }

  private void givenPages(String... pageNames) {
    // ...
  }

  private void whenRequestIsIssued(String resource, String type) {
    // ...
  }

  private void thenResponseShouldBeXML() {
    // ...
  }

  private void thenResponseShouldContain(String... strings) {
    // ...
  }
}
