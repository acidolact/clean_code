// Листинг 8.1 LogTest.java — Учебные тесты для log4j
//
// Вместо того чтобы экспериментировать и опробовать новую библиотеку
// в коде продукта, можно написать тесты, проверяющие наше понимание
// стороннего кода. Джим Ньюкирк называет такие тесты «учебными тестами».
//
// В учебных тестах мы вызываем методы стороннего API в том виде,
// в котором намереваемся использовать их в своем приложении.
// Фактически выполняется контролируемый эксперимент, проверяющий
// наше понимание стороннего API.
//

public class LogTest {

  private Logger logger;

  @Before
  public void initialize() {
    logger = Logger.getLogger("logger");
    logger.removeAllAppenders();
    Logger.getRootLogger().removeAllAppenders();
  }

  @Test
  public void basicLogger() {
    BasicConfigurator.configure();
    logger.info("basicLogger");
  }

  @Test
  public void addAppenderWithStream() {
    logger.addAppender(new ConsoleAppender(
      new PatternLayout("%p %t %m%n"),
      ConsoleAppender.SYSTEM_OUT));
    logger.info("addAppenderWithStream");
  }

  @Test
  public void addAppenderWithoutStream() {
    logger.addAppender(new ConsoleAppender(
      new PatternLayout("%p %t %m%n")));
    logger.info("addAppenderWithoutStream");
  }
}

class Logger {
  static Logger getLogger(String name) { return new Logger(); }
  static Logger getRootLogger() { return new Logger(); }
  void removeAllAppenders() {}
  void info(String message) {}
  void addAppender(ConsoleAppender appender) {}
}

class ConsoleAppender {
  static final Object SYSTEM_OUT = new Object();
  ConsoleAppender(PatternLayout layout, Object stream) {}
  ConsoleAppender(PatternLayout layout) {}
}

class PatternLayout {
  PatternLayout(String pattern) {}
}

class BasicConfigurator {
  static void configure() {}
}
