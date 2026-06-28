// Листинг 6.2 Point — Абстрактная реализация
//
// Внешний пользователь не знает, какие координаты использованы
// в реализации — прямоугольные или полярные. А может, еще какие-нибудь!
//
// Методы устанавливают политику доступа к данным:
// координаты можно читать независимо, но присваивание — атомарно.
//

public interface Point {

  double getX();
  double getY();
  void setCartesian(double x, double y);
  double getR();
  double getTheta();
  void setPolar(double r, double theta);
}
