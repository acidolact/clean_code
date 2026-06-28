// Листинг 5.10 FitNesseExpediter.java — Горизонтальное выравнивание
//
// Переменные в функции располагаются рядом с первым местом использования.
// Концептуально связанные переменные группируются вместе.
//

package fitnesse.wikitext.widgets;

import java.io.*;

public class FitNesseExpediter implements ResponseSender {

  private Socket socket;
  private InputStream input;
  private OutputStream output;
  private Request request;
  private Response response;
  private FitNesseContext context;

  protected long requestParsingTimeLimit;
  private long requestProgress;
  private long requestParsingDeadline;
  private boolean hasError;

  public FitNesseExpediter(Socket s, FitNesseContext context) throws Exception {
    this.context = context;
    socket = s;
    input = s.getInputStream();
    output = s.getOutputStream();
    requestParsingTimeLimit = 10000;
  }
}

// Вспомогательные интерфейсы/классы
interface ResponseSender {}
class Socket {
  InputStream getInputStream() { return null; }
  OutputStream getOutputStream() { return null; }
}
class InputStream {}
class OutputStream {}
class Request {}
class Response {}
class FitNesseContext {}
