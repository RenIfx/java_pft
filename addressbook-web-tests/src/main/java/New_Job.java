//Обновленная версия
//оптимизирован поиск
//Добавлен красивый вывод символов.

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class New_Job {
  public static void main(String[] args) {
/*/ Input String-----------------------------------------
    Scanner scan = new Scanner(System.in);  //||
    String a = getString(scan);                     // ||
//Input Word                                            // ||
    System.out.print("Input Word: ");          // ||
    String b = scan.next();                          // ||
                                                             // ||
    <=============================// ||
            Input Example                             //  ||
   */ String a = "QLGNAEKIRLRNGEAE";            //  ||
    String b = "KING";                                // ||
 // <==============================||
    quad(a, b);
  }

  //check characters for square
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

  public static void quad(String sim, String sl) { //fill in the main and auxiliary arrays

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

// finding coordinates and displaying
    find(slo, ok);
  }

  private static void find(char[] slo, char[][] ok) {

    printArr(slo, ok);

    int p = 0;
    int i = 0;
     {
      for (int n = 0; n < ok.length; n++) {
        if (slo[p] == ok[i][n]) {
          if (p < (slo.length - 1)) {
            System.out.print("[" + i + "," + n + "]");
            extra(slo, ok, p, i, n);
          }/* else {
            System.out.print("[" + i + "," + n + "]");
            break;
          }
          */
        }
        if (n == 3 && p != (slo.length - 1)) {
          i++;
          n = 0;
        }
      }
    } while (p < slo.length - 1);
  }

  private static void extra(char[] slo, char[][] ok, int p, int i, int n) {
    int x = i;
    int y = n;
    p++;
    do {
      if (slo[p] == ok[x - 1][y] && x > 1) {
        System.out.print("->[" + (x - 1) + "," + y + "]");
        x = x - 1;p++;
        extra(slo, ok, p, x, y);
      } else if (slo[p] == ok[x + 1][y] && x < ok.length - 1) {
        System.out.print("->[" + (x + 1) + "," + y + "]");
        x = x + 1;p++;
        extra(slo, ok, p, x, y);
      } else if (slo[p] == ok[x][y - 1] && y > 1) {
        System.out.print("->[" + x + "," + (y - 1) + "]");
        y = y - 1;p++;
        extra(slo, ok, p, x, y);
      } else if (slo[p] == ok[x][y + 1] && y < ok.length - 1) {
        System.out.print("->[" + x + "," + (y + 1) + "]");
        y = y + 1;extra(slo, ok, p, x, y);
      }

    } while (p < slo.length - 1);
  }

  //output on display
  private static void printArr(char[] slo, char[][] ok) {
    System.out.println();
    for (int i = 0; i < ok.length; i++) {
      for (int n = 0; n < ok.length; n++) {
        System.out.print(" {" + ok[i][n] + "} ");
      }
      System.out.println();
    }
    System.out.println();
    for (int i = 0; i < slo.length; i++) {
      System.out.print(" {" + slo[i] + "} ");
    }
    System.out.println();
  }
}

