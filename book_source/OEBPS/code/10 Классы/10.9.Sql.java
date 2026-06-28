// Листинг 10.9 Sql — Класс, который необходимо открыть для внесения изменений
//
// Класс Sql изменяется при добавлении нового типа команды. Кроме того,
// он будет изменяться при изменении подробностей реализации уже
// существующего типа команды — скажем, если нам понадобится изменить
// функциональность select для поддержки подчиненной выборки.
//
// Две причины для изменения означают, что класс Sql нарушает принцип
// единой ответственности.
//

public class Sql {

  public Sql(String table, Column[] columns) {}
  public String create() {}
  public String insert(Object[] fields) {}
  public String selectAll() {}
  public String findByKey(String keyColumn, String keyValue) {}
  public String select(Column column, String pattern) {}
  public String select(Criteria criteria) {}
  public String preparedInsert() {}
  private String columnList(Column[] columns) {}
  private String valuesList(Object[] fields, Column[] columns) {}
  private String selectWithCriteria(String criteria) {}
  private String placeholderList(Column[] columns) {}
}

class Column {}
class Criteria {}
