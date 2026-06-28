// Листинг 9.3 EnvironmentControllerTest.java — Простой тест (до переработки)
//
// Этот тест проверяет, что при слишком низкой температуре включается
// механизм оповещения о низкой температуре, обогреватель и система
// подачи нагретого воздуха.
//
// В этом листинг содержит множество ненужных подробностей. Например,
// что делает функция tic? Я бы предпочел, чтобы читатель не задумывался
// об этом в ходе чтения теста.
//

public class EnvironmentControllerTest {

  @Test
  public void turnOnLoTempAlarmAtThreashold() throws Exception {
    hw.setTemp(WAY_TOO_COLD);
    controller.tic();
    assertTrue(hw.heaterState());
    assertTrue(hw.blowerState());
    assertFalse(hw.coolerState());
    assertFalse(hw.hiTempAlarm());
    assertTrue(hw.loTempAlarm());
  }

  MockControlHardware hw = new MockControlHardware();
  EnvironmentController controller = new EnvironmentController();

  static final int WAY_TOO_COLD = 0;
}

class MockControlHardware {
  void setTemp(int temp) {}
  boolean heaterState() { return false; }
  boolean blowerState() { return false; }
  boolean coolerState() { return false; }
  boolean hiTempAlarm() { return false; }
  boolean loTempAlarm() { return false; }
}

class EnvironmentController {
  void tic() {}
}
