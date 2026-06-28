// Листинг 5.4 читается гораздо проще. Он нормально воспринимается «с одного взгляда» — по крайней мере, для меня. Я смотрю на него и сразу вижу, что передо мной класс с двумя переменными и одним методом; для этого мне не приходится вертеть головой или бегать по строчкам глазами. В предыдущем листинге для достижения того же уровня понимания приходится потрудиться намного больше.

public class ReporterConfig {

  private String m_className;

  private List<Property> m_properties = new ArrayList<Property>();

  public void addProperty(Property property) {
    m_properties.add(property);
  }
}
