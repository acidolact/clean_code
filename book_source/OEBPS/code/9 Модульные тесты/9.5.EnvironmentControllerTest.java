// Листинг 9.5 EnvironmentControllerTest.java — Расширенный набор
//
// Функции getState приведена в листинге 9.6. Обратите внимание:
// эффективность этого кода оставляет желать лучшего. Чтобы сделать
// его более эффективным, вероятно, мне стоило использовать класс
// StringBuffer.
//
// Функции getState приведена в листинге 9.6.
//

public class EnvironmentControllerTest {

  @Test
  public void turnOnCoolerAndBlowerIfTooHot() throws Exception {
    tooHot();
    assertEquals("hBChl", hw.getState());
  }

  @Test
  public void turnOnHeaterAndBlowerIfTooCold() throws Exception {
    tooCold();
    assertEquals("HBchl", hw.getState());
  }

  @Test
  public void turnOnHiTempAlarmAtThreshold() throws Exception {
    wayTooHot();
    assertEquals("hBCHl", hw.getState());
  }

  @Test
  public void turnOnLoTempAlarmAtThreshold() throws Exception {
    wayTooCold();
    assertEquals("HBchL", hw.getState());
  }

  MockControlHardware hw = new MockControlHardware();

  private void tooHot() {
    hw.setTemp(TOO_HOT);
    controller.tic();
  }

  private void tooCold() {
    hw.setTemp(TOO_COLD);
    controller.tic();
  }

  private void wayTooHot() {
    hw.setTemp(WAY_TOO_HOT);
    controller.tic();
  }

  private void wayTooCold() {
    hw.setTemp(WAY_TOO_COLD);
    controller.tic();
  }

  EnvironmentController controller = new EnvironmentController();

  static final int TOO_HOT = 100;
  static final int TOO_COLD = 0;
  static final int WAY_TOO_HOT = 200;
  static final int WAY_TOO_COLD = -10;
}

class MockControlHardware {
  void setTemp(int temp) {}
  String getState() { return ""; }
}

class EnvironmentController {
  void tic() {}
}
