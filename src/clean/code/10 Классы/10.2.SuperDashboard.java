// Листинг 10.2 SuperDashboard — Достаточно компактно?
//
// Пять методов — не слишком много, не так ли? В нашем случае слишком,
// потому что несмотря на малое количество методов, класс SuperDashboard
// по-прежнему имеет слишком много ответственностей.
//
// Имя класса должно описывать его ответственности. В сущности, имя
// должно стать первым фактором, способствующим определению размера класса.
// Если для класса не удается подобрать четкое, короткое имя, вероятно,
// он слишком велик.
//

public class SuperDashboard extends JFrame implements MetaDataUser {

  public Component getLastFocusedComponent() {}
  public void setLastFocused(Component lastFocused) {}
  public int getMajorVersionNumber() {}
  public int getMinorVersionNumber() {}
  public int getBuildNumber() {}
}

class JFrame {}
class MetaDataUser {}
class Component {}
