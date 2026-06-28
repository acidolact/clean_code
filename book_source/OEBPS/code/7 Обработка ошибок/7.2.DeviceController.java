// Листинг 7.2 DeviceController.java — С исключениями
//
// Выдача исключений в методах, способных обнаруживать ошибки.
// Код вызова становится более понятным, а его логика не скрывается
// за кодом обработки ошибок.
//
// Два аспекта — алгоритм отключения устройства и обработка ошибок —
// теперь изолированы друг от друга.
//

public class DeviceController {

  public void sendShutDown() {
    try {
      tryToShutDown();
    } catch (DeviceShutDownError e) {
      logger.log(e);
    }
  }

  private void tryToShutDown() throws DeviceShutDownError {
    DeviceHandle handle = getHandle(DEV1);
    DeviceRecord record = retrieveDeviceRecord(handle);

    pauseDevice(handle);
    clearDeviceWorkQueue(handle);
    closeDevice(handle);
  }

  private DeviceHandle getHandle(DeviceID id) throws DeviceShutDownError {
    // ...
    throw new DeviceShutDownError("Invalid handle for: " + id.toString());
    // ...
  }
}

class DeviceShutDownError extends Exception {
  DeviceShutDownError(String message) {}
}

class Logger {
  void log(DeviceShutDownError e) {}
}
