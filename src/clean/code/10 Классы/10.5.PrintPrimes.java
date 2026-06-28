// Листинг 10.5 PrintPrimes.java — Программа Кнута, переведенная на Java
//
// Для демонстрации мы воспользуемся проверенным временем примером из
// замечательной книги Кнута «Literate Programming». В листинг 10.5
// представлена программа PrintPrimes, переведенная на Java.
// Это не та программа, которую написал Кнут, а та, которую выводит
// его утилита WEB. Я воспользуюсь ей, потому что она является отличной
// отправной точкой для разбиения большой функции на несколько меньших
// функций и классов.
//

package literatePrimes;

public class PrintPrimes {

  public static void main(String[] args) {
    final int M = 1000;
    final int RR = 50;
    final int CC = 4;
    final int WW = 10;
    final int ORDMAX = 30;
    int P[] = new int[M + 1];
    int PAGENUMBER;
    int PAGEOFFSET;
    int ROWOFFSET;
    int C;
    int J;
    int K;
    boolean JPRIME;
    int ORD;
    int SQUARE;
    int N;
    int MULT[] = new int[ORDMAX + 1];

    J = 1;
    K = 1;
    P[1] = 2;
    ORD = 2;
    SQUARE = 9;

    while (K < M) {
      do {
        J = J + 2;
        if (J == SQUARE) {
          ORD = ORD + 1;
          SQUARE = P[ORD] * P[ORD];
          MULT[ORD - 1] = J;
        }
        N = 2;
        JPRIME = true;
        while (N < ORD && JPRIME) {
          while (MULT[N] < J)
            MULT[N] = MULT[N] + P[N] + P[N];
          if (MULT[N] == J)
            JPRIME = false;
          N = N + 1;
        }
      } while (!JPRIME);
      K = K + 1;
      P[K] = J;
    }

    PAGENUMBER = 1;
    PAGEOFFSET = 1;
    while (PAGEOFFSET <= M) {
      System.out.println("The First " + M +
        " Prime Numbers --- Page " + PAGENUMBER);
      System.out.println("");
      for (ROWOFFSET = PAGEOFFSET;
           ROWOFFSET < PAGEOFFSET + RR;
           ROWOFFSET++) {
        for (C = 0; C < CC; C++) {
          int index = ROWOFFSET + C * RR;
          if (index <= M) {
            System.out.printf("%" + WW + "d", P[index]);
          }
        }
        System.out.println("");
      }
      PAGEOFFSET += RR;
      PAGENUMBER++;
    }
  }
}
