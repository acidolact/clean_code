// Листинг 7.1 DeviceController.java — Коды ошибок (старый подход)
//
// На первый взгляд обработка ошибок выглядит рутинной. Но из-за
// разбросанной повсюду обработки ошибок практически невозможно понять,
// что же делает код.
//
// Оба способа (флаг ошибки и код ошибки) загромождают код на стороне
// вызова. Вызывающая сторона должна проверять ошибки немедленно после
// вызова. Об этом легко забыть.
//

public class DeviceController {

  public void sendShutDown() {
    DeviceHandle handle = getHandle(DEV1);

    // Проверить состояние устройства
    if (handle != DeviceHandle.INVALID) {
      // Сохранить состояние устройства в поле записи
      retrieveDeviceRecord(handle);

      // Если устройство не приостановлено, отключить его
      if (record.getStatus() != DEVICE_SUSPENDED) {
        pauseDevice(handle);
        clearDeviceWorkQueue(handle);
        closeDevice(handle);
      } else {
        logger.log("Device suspended. Unable to shut down");
      }
    } else {
      logger.log("Invalid handle for: " + DEV1.toString());
    }
  }

  private DeviceHandle getHandle(DeviceID id) {
    // ...
    return DeviceHandle.INVALID;
    // ...
  }

  private DeviceRecord retrieveDeviceRecord(DeviceHandle handle) {
    // ...
    return new DeviceRecord();
    // ...
  }

  private void pauseDevice(DeviceHandle handle) {
    // ...
  }

  private void clearDeviceWorkQueue(DeviceHandle handle) {
    // ...
  }

  private void closeDevice(DeviceHandle handle) {
    // ...
  }
}

class DeviceHandle {
  static final DeviceHandle INVALID = new DeviceHandle();
}

class DeviceRecord {
  int getStatus() { return 0; }
}

class DeviceID {
  String toString() { return "DEV1"; }
}

class Logger {
  void log(String message) {}
}
