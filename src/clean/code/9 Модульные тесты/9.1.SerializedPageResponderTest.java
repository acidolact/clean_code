// Листинг 9.1 SerializedPageResponderTest.java — Тестовый API не проектируется заранее
//
// Тестовый API развивается на базе многократной переработки тестового кода,
// перегруженного ненужными подробностями. По аналогии с тем, как я переработал
// листинг 9.1 в листинг 9.2, дисциплинированные разработчики перерабатывают
// свой тестовый код в более лаконичные и выразительные формы.
//

public class SerializedPageResponderTest {

  public void testGetPageHierarchyAsXml() throws Exception {
    givenPages("PageOne", "PageOne.ChildOne", "PageTwo");

    whenRequestIsIssued("root", "type:pages");

    thenResponseShouldBeXML();
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
