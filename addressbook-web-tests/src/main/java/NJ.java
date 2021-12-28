/*//Обновленная версия
//оптимизирован поиск
//Добавлен красивый вывод символов./*


import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class NJ {
  public static void main(String[] args) {
// Ввод строки
    Scanner scan = new Scanner(System.in);
    String a = getString(scan);
//Ввод слова
    System.out.print("Input Word: ");
    String b = scan.next();
    scan.close();
    quad(a, b);

  }

  //проверка символов на квадратность
  @NotNull
  private static String getString(Scanner scanner) {
    String a;
    double m;
    double m1;
    do {
      System.out.print("Input string of size N^2, that describes square matrix of characters N*N: ");
      a = scanner.nextLine();
      int l = a.length();
      m = Math.sqrt(l);
      m1 = (int) m;
      if (!(m == m1)) {
        System.out.println("Error - string is not of size N ^ 2.Input string again.");
      }
    }
    while (!(m == m1));
    System.out.println("Bingo!");
    return a;
  }


  public static void quad(String sim, String sl) { //заполняем основной и вспомогательные масивы

    int l = sim.length();
    double m = Math.sqrt(l);
    int m1 = (int) m;
    char[] buk = sim.toCharArray();
    char[] slo = sl.toCharArray();
    char[][] ok = new char[m1][m1];
    int b = 0;
    for (int i = 0; i < ok.length; i++) {
      for (int n = 0; n < ok.length; n++) {
        ok[i][n] = buk[b];
        b++;
      }
    }
// поиск координат и вывод на экран
    int p=0;
    while (p!=slo.length-1){
      for (int i = 0; i < ok.length; i++) {//nen сделать вайл
        for (int n = 0; n < ok.length; n++) {
          if (slo[p] == ok[i][n]&&p<=slo.length-1) {
              System.out.print("[" + i + "," + n + "]->");
             if(p< slo.length-1) {p++;};
              i=0;
              n=0;
              continue;
            } else if (slo[p] == ok[i][n]&&p< slo.length-1){
              System.out.print("[" + i + "," + n + "]");
              if(p< slo.length-1) {p++;};
              i=0;n=0;
              continue;
            }

          }
        if (p== slo.length){break;}
        }

    }
  }
}*/