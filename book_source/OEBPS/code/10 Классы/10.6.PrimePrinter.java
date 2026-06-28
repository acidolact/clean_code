// Листинг 10.6 PrimePrinter.java — Переработанная версия
//
// Большая функция разбита на меньшие фрагменты, что открывает
// возможность для выделения нескольких меньших классов.
// В результате строение программы улучшается, а ее структура
// становится более прозрачной.
//

package literatePrimes;

public class PrimePrinter {

  public static void main(String[] args) {
    final int NUMBER_OF_PRIMES = 1000;
    int[] primes = PrimeGenerator.generate(NUMBER_OF_PRIMES);

    final int ROWS_PER_PAGE = 50;
    final int COLUMNS_PER_PAGE = 4;
    RowColumnPagePrinter tablePrinter =
      new RowColumnPagePrinter(ROWS_PER_PAGE,
        COLUMNS_PER_PAGE,
        "The First " + NUMBER_OF_PRIMES +
        " Prime Numbers");

    tablePrinter.print(primes);
  }
}
