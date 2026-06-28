// Листинг 5.5 WikiPageResponder.java
//
// Листинг 5.5 имеет именно такую структуру — от высокого уровня к более низкому.
// Как и в газетных статьях, читатель ожидает, что самые важные концепции будут
// изложены сначала.
//
// Каждая функция находится на одном уровне абстракции, а имена функций
// отражают этот уровень.

package fitnesse.wikitext.widgets;

public class WikiPageResponder implements SecureResponder {
  protected WikiPage page;
  protected PageData pageData;
  protected String pageTitle;
  protected Request request;
  protected PageCrawler crawler;

  public Response makeResponse(FitNesseContext context, Request request)
    throws Exception {
    String pageName = getPageNameOrDefault(request, "FrontPage");
    loadPage(pageName, context);
    if (page == null)
      return notFoundResponse(context, request);
    else
      return makePageResponse(context);
  }

  private String getPageNameOrDefault(Request request, String defaultPageName)
  {
    String pageName = request.getResource();
    if (StringUtil.isBlank(pageName))
      pageName = defaultPageName;

    return pageName;
  }

  protected void loadPage(String resource, FitNesseContext context)
    throws Exception {
    WikiPagePath path = PathParser.parse(resource);
    crawler = context.root.getPageCrawler();
    crawler.setDeadEndStrategy(new VirtualEnabledPageCrawler());
    page = crawler.getPage(context.root, path);
    if (page != null)
      pageData = page.getData();
  }

  private Response notFoundResponse(FitNesseContext context, Request request)
    throws Exception {
    return new NotFoundResponder().makeResponse(context, request);
  }

  private SimpleResponse makePageResponse(FitNesseContext context)
    throws Exception {
    pageTitle = PathParser.render(crawler.getFullPath(page));
    String html = makeHtml(context);

    SimpleResponse response = new SimpleResponse();
    response.setMaxAge(0);
    response.setContent(html);
    return response;
  }
}

// Вспомогательные интерфейсы/классы
interface SecureResponder {
  Response makeResponse(FitNesseContext context, Request request) throws Exception;
}

class WikiPage {}
class PageData {}
class Request {
  String getResource() { return ""; }
}
class FitNesseContext {
  WikiPage root = new WikiPage();
  WikiPage getPageCrawler() { return null; }
}
class PageCrawler {
  WikiPage getPage(WikiPage root, WikiPagePath path) { return null; }
  String getFullPath(WikiPage page) { return ""; }
  void setDeadEndStrategy(VirtualEnabledPageCrawler strategy) {}
}
class WikiPagePath {}
class PathParser {
  static WikiPagePath parse(String resource) { return new WikiPagePath(); }
  static String render(String fullPath) { return ""; }
}
class StringUtil {
  static boolean isBlank(String pageName) { return false; }
}
class VirtualEnabledPageCrawler {}
class NotFoundResponder {
  Response makeResponse(FitNesseContext context, Request request) { return null; }
}
class SimpleResponse {
  void setMaxAge(int maxAge) {}
  void setContent(String html) {}
}
class Response {}
