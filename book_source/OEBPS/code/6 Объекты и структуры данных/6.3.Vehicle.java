// Листинг 6.3 Vehicle — Конкретная реализация
//
// Для получения информации о запасе топлива используются
// конкретные физические показатели.
// Пользователь вынужден работать с этими конкретными единицами.
//

public interface Vehicle {

  double getFuelTankCapacityInGallons();
  double getGallonsOfGasoline();
}
