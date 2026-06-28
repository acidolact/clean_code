// Листинг 10.4 Stack.java — Класс с высокой связностью
//
// Классы должны иметь небольшое количество переменных экземпляров.
// Каждый метод класса должен оперировать с одной или несколькими из
// этих переменных. В общем случае, чем с большим количеством переменных
// работает метод, тем выше связность.
//

public class Stack {

  private int topOfStack = 0;
  List<Integer> elements = new LinkedList<Integer>();

  public int size() {
    return topOfStack;
  }

  public void push(int element) {
    topOfStack++;
    elements.add(element);
  }

  public int pop() throws PoppedWhenEmpty {
    if (topOfStack == 0)
      throw new PoppedWhenEmpty();

    int element = elements.get(--topOfStack);
    elements.remove(topOfStack);
    return element;
  }
}

class PoppedWhenEmpty extends Exception {}
