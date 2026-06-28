// Листинг 7.3 — Начните с try-catch-finally
//
// У исключений есть одна интересная особенность: они определяют
// область видимости в вашей программе. Размещая код в секции try,
// вы утверждаете, что выполнение программы может прерваться в любой
// точке, а затем продолжиться в секции catch.
//
// Блоки try в каком-то отношении напоминают транзакции. Секция catch
// должна оставить программу в целостном состоянии, что бы ни произошло
// в секции try.
//

public List<RecordedGrip> retrieveSection(String sectionName) {
  try {
    FileInputStream stream = new FileInputStream(sectionName);
    stream.close();
  } catch (FileNotFoundException e) {
    throw new StorageException("retrieval error", e);
  }
  return new ArrayList<RecordedGrip>();
}

class StorageException extends Exception {
  StorageException(String message, Exception cause) {}
}

class RecordedGrip {}
