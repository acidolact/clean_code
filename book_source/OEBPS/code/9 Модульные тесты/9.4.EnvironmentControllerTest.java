// Листинг 9.4 EnvironmentControllerTest.java — Переработанная версия
//
// Новая форма теста, которая читается гораздо проще.
// Я скрыл функцию tic, создав более понятную функцию wayTooCold.
// Но особого внимания заслуживает странная строка в вызове assertEquals.
// Верхний регистр означает включенное состояние, нижний регистр — выключенное,
// а буквы всегда следуют в определенном порядке:
// {обогреватель, подача воздуха, охладитель, сигнал о высокой температуре,
//  сигнал о низкой температуре}.
//

public class EnvironmentControllerTest {

  @Test
  public void turnOnLoTempAlarmAtThreshold() throws Exception {
    wayTooCold();
    assertEquals("HBchL", hw.getState());
  }

  MockControlHardware hw = new MockControlHardware();

  private void wayTooCold() {
    hw.setTemp(WAY_TOO_COLD);
    controller.tic();
  }

  EnvironmentController controller = new EnvironmentController();

  static final int WAY_TOO_COLD = 0;
}

class MockControlHardware {
  void setTemp(int temp) {}
  String getState() { return ""; }
}

class EnvironmentController {
  void tic() {}
}
