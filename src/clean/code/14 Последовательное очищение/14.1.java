// Листинг 14.1
// Контекст:  не окажется удобного инструмента, мы просто перебираем элементы массива строк, переданного функции main. Я знал немало хороших инструментов из разных источников, однако ни один из них не делал именно того, что мне было нужно. Разумеется, я решил написать собственную реализацию — назовем ее Args. Класс Args очень прост в использовании. Вы конструируете экземпляр класса Args с входными аргументами и форматной строкой, а затем обращаетесь к нему за значениями аргументов. Рассмотрим простой пример.

public static void main(String[] args) {
try {
Args arg = new Args("l,p#,d*", args);
boolean logging = arg.getBoolean('l');
int port = arg.getInt('p');
String directory = arg.getString('d');
executeApplication(logging, port, directory);
} catch (ArgsException e) {
System.out.printf("Argument error: %s\n", e.errorMessage());
}
}