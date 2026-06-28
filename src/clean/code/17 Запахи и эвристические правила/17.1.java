// Листинг 17.1
// Контекст:  не только логической, но и физической. Зависимый модуль не должен делать никаких предположений (иначе говоря, создавать логические зависимости) относительно того модуля, от которого он зависит. Вместо этого он должен явно запросить у этого модуля всю необходимую информацию. Допустим, вы пишете функцию, которая выводит текстовый отчет об от­ра­ботанном времени. Класс с именем HourlyReporter собирает все данные в удобной форме и передает их классу HourlyReportFormatter для вывода (лис­тинг 17.1).

public class HourlyReporter {
private HourlyReportFormatter formatter;
private List<LineItem> page;
private final int PAGE_SIZE = 55;

public HourlyReporter(HourlyReportFormatter formatter) {
this.formatter = formatter;
page = new ArrayList<LineItem>();
}

public void generateReport(List<HourlyEmployee> employees) {
for (HourlyEmployee e : employees) {
addLineItemToPage(e);
if (page.size() == PAGE_SIZE)
printAndClearItemList();
}
if (page.size() > 0)
printAndClearItemList();
}

private void printAndClearItemList() {
formatter.format(page);
page.clear();
}

private void addLineItemToPage(HourlyEmployee e) {
LineItem item = new LineItem();
item.name = e.getName();
item.hours = e.getTenthsWorked() / 10;
item.tenths = e.getTenthsWorked() % 10;
page.add(item);
}

public class LineItem {
public String name;
public int hours;
public int tenths;
}
}