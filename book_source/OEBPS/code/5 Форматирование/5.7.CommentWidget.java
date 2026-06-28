// Листинг 5.7 CommentWidget.java — Развернутые блоки
//
// Развернутые блоки (expanded blocks) — когда открывающая скобка
// стоит на отдельной строке. Это один из двух допустимых стилей.
//

package fitnesse.wikitext.widgets;

public class CommentWidget extends TextWidget {

  public static final String REGEXP = "^#[^\r\n]*(?:(?:\r\n)|\n|\r)?";

  public CommentWidget(ParentWidget parent, String text) {
    super(parent, text);
  }

  public String render() throws Exception {
    return "";
  }
}

// Вспомогательные классы
class TextWidget {
  TextWidget(ParentWidget parent, String text) {}
}
class ParentWidget {}
