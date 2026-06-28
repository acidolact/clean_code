// Листинг 14.3
// Контекст: turn StringArrayArgumentMarshaler.getValue(marshalers.get(arg)); } } Обратите внимание: код читается сверху вниз, и вам не приходится постоянно переходить туда-сюда или заглядывать вперед. Единственное место, где все же необходимо заглянуть вперед, — это определение ArgumentMarshaler, но и это было сделано намеренно. Внимательно прочитав этот код, вы поймете, что собой представляет интерфейс ArgumentMarshaler и что делают производные классы. Примеры таких классов приведены в листингах 14.3–14.6.

public interface ArgumentMarshaler {
void set(Iterator<String> currentArgument) throws ArgsException;
}