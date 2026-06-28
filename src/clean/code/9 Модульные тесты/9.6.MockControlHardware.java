// Листинг 9.6 MockControlHardware.java — getState
//
// Обратите внимание: эффективность этого кода оставляет желать лучшего.
// Чтобы сделать его более эффективным, вероятно, мне стоило использовать
// класс StringBuffer.
//
// Класс StringBuffer некрасив и неудобен. Даже в коде продукта я стараюсь
// избегать его, если это не приводит к большим потерям; конечно, в коде
// из листинга 9.6 потери невелики.
//
// Однако следует учитывать, что приложение пишется для встроенной
// системы реального времени, в которой вычислительные ресурсы и память
// сильно ограничены. С другой стороны, в среде тестирования такие
// ограничения отсутствуют. В этом проявляется природа двойного стандарта.
//

public class MockControlHardware {

  boolean heater;
  boolean blower;
  boolean cooler;
  boolean hiTempAlarm;
  boolean loTempAlarm;

  public String getState() {
    String state = "";
    state += heater ? "H" : "h";
    state += blower ? "B" : "b";
    state += cooler ? "C" : "c";
    state += hiTempAlarm ? "H" : "h";
    state += loTempAlarm ? "L" : "l";
    return state;
  }
}
