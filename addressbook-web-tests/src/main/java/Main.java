//Ты можешь добавлять свои импорты
//import java.io.IOException;
//import java.lang.Exception;
//import java.lang.NumberFormatException;

//решение должно содержать данный класс
class Main {
  public static void main(String[] args) {
    String[] in = {" 4 + 3,5 ", " 4.5 + 3 ", "     9 - 10       ", "  -1   ", "   4  -  1   ", "1 ", "2-1", "10+11", "1 - 2", "2*3", "2*0", "3/2", "4/0", "I+V", "VI-IV", "IX*V", "X/VII", "1+1+2", "1-2+2", "", "III+XIII", "XI+XV", null};

    for (String s : in) {
      System.out.println("Входящие данные: " + s + " расчитанные данные = " + calc(s));
    }
    // System.out.println("Входящие данные: " + "XI+XV" + " расчитанные данные = " + calc("XI+XV"));
  }

  //Решение должно содержать данный метод
  public static String calc(String inputString) {

    if (inputString == null) {
      return null;
    }//проверка на нулл
    inputString = inputString.toUpperCase();//Регистр вверх
    inputString = chist(inputString);//чистим от пробелов и проверяем на точки и запятые

    if (inputString.length() < 3) {
      try {
        throw new MyException();
      } catch (MyException e) {
        System.out.println("исключение!");
        return null;
      }
    }//неверный ввод
String vid="";
  try {
    vid = romOrArab(inputString);//вид переменных араб или рим
    } catch (MyException e) {
      System.out.println("исключение.");
    }
    String oper = "";
    try {
      oper = oper(inputString);//вид действия +-*/ какой внутри

    } catch (MyException e) {
      System.out.println("исключение.");
    }
    String ravno = "";
    try {
      ravno = ravno(inputString, oper, vid);
    } catch (MyException e) {
      System.out.println("исключение.");
    }
    if (ravno == null) {
      try {
        throw new MyException();
      } catch (MyException e) {
        System.out.println("исключение.");
      }
    }
    return ravno;
  }

  //чистим от пробелов
  private static String chist(String x) {
    String z = "";
    char[] y = x.toCharArray();
    for (char c : y) {
      if (c == '.'||c == ',') {
        return "-1";
      }
      if (c != ' ') {
        z = z + c;
      }
    }
    return z;
  }


  //Равно вывод, завершающий метод
  private static String ravno(String input, String deystvie, String vidCifr) throws MyException {
    if (deystvie == null || vidCifr == null) {
      return null;
    }
    String ravno = "";
    if (deystvie.equals("P")) {
      ravno = sum(input, vidCifr);
    }
    if (deystvie.equals("M")) {
      ravno = minus(input, vidCifr);
    }
    if (deystvie.equals("U")) {
      ravno = umn(input, vidCifr);
    }
    if (deystvie.equals("D")) {
      ravno = del(input, vidCifr);
    }

    return ravno;
  }

  //Проверка какие операторы внутри
  private static String oper(String inputString) throws MyException {
    String znak = "";
    char[] sim = inputString.toCharArray();
    int kol = 0;
    for (char s : sim) {
      if (s == '+') {
        kol++;
        znak = "P";
      }
      if (s == '-') {
        kol++;
        znak = "M";
      }
      if (s == '*') {
        kol++;
        znak = "U";
      }
      if (s == '/') {
        kol++;
        znak = "D";
      }
    }
    if (kol == 0 || kol > 1) {
      return null;
    }//проверка на наличие 2х разных операторов

    return znak;
  }

  //Проверка Араб или Рим
  private static String romOrArab(String inputString) throws MyException{
    int y = 0;
    String cal = "";
    for (int i = 0; i < 10; i++) {
      char m = (char) (i + '0');
      if (inputString.charAt(0) == m) {
        y++;
      }//проверка первого символа на Рим
      if (inputString.charAt((inputString.length() - 1)) == m) {
        y++;
        if (y > 1) {
          break;
        }
      }//проверка последнего символа на Рим
    }
    if (y == 1) {
      return null;
    }//не Рим и не Араб

    if (y == 2) {
      if (inputString.charAt(1) != 'I' && inputString.charAt(1) != 'V' && inputString.charAt(1) != 'X') {
        if (inputString.charAt(inputString.length() - 2) != 'I' && inputString.charAt(inputString.length() - 2) != 'V' && inputString.charAt(inputString.length() - 2) != 'X') {
          cal = "A";
        }//Араб с проверкой 2 и предпоследнего символа
      }
    }

    if (y == 0) {
      for (int i = 0; i < 10; i++) {
        char m = (char) (i + '0');
        if (inputString.charAt(1) == m) {
          return null;
        }//проверка второго символа на Рим
        if (inputString.charAt((inputString.length() - 2)) == m) {
          return null;
        }

      }
      cal = "R";//Рим
    }//проверка пред-последнего символа на Рим
    if (cal.equals("")) {
      return null;
    }
    return cal;
  }


  // Сумма
  private static String sum(String inputString, String rab) {

    String[] vmas = inputString.split("\\+");//в масив 2 числа или более
    if (vmas.length > 2) {
      return null;
    } //Проверка на колво одинаковых операторов

    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }//перевод из рима в араб если необходимо

    int a1 = 0, a2 = 0;
    String x = "";

    a1 = Integer.parseInt(vmas[0]);
    a2 = Integer.parseInt(vmas[1]);

    if (a2 <= 0 || a2 > 10) {
      return null;
    } //проверка на условие значения цифр
    if (a1 <= 0 || a1 > 10) {
      return null;
    }//проверка на условие значения цифр
    int sum = a1 + a2;
    x = x + sum;
    if (rab.equals("R")) {
      x = atr(x);
    }
    return x;
  }

  // Разность
  private static String minus(String inputString, String rab) {

    String[] vmas = inputString.split("-");//в масив 2 значения или более
    if (vmas.length > 2) {
      return null;
    } //Проверка на колво одинаковых операторов

    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }//перевод из рима в араб

    int a1 = 0, a2 = 0;
    String x = "";
    a1 = Integer.parseInt((vmas[0]));
    a2 = Integer.parseInt(vmas[1]);
    if (a2 <= 0 || a2 > 10) {
      return null;
    } //проверка на условие значения цифр
    if (a1 <= 0 || a1 > 10) {
      return null;
    }//проверка на условие значения цифр
    int sum = a1 - a2;
    if (sum <= 0) {
      return null;
    }
    x = x + sum;
    if (rab.equals("R")) {
      x = atr(x);
    }//перевод из  араб в рима
    return x;
  }

  // Произведение
  private static String umn(String inputString, String rab) {

    String[] vmas = inputString.split("\\*");//в масив 2 значения или более
    if (vmas.length > 2) {//Проверка на колво одинаковых операторов
      return null;
    }

    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }

    int a1 = 0, a2 = 0;
    String x = "";
    a1 = Integer.parseInt((vmas[0]));
    a2 = Integer.parseInt(vmas[1]);
    if (a2 <= 0 || a2 > 10) {
      return null;
    } //проверка на условие значения цифр
    if (a1 <= 0 || a1 > 10) {
      return null;
    }//проверка на условие значения цифр
    int sum = a1 * a2;
    x = x + sum;
    if (rab.equals("R")) {
      x = atr(x);
    }
    return x;
  }

  // Деление
  private static String del(String inputString, String rab) {

    String[] vmas = inputString.split("/");//в масив 2 значения или более
    if (vmas.length > 2) {//Проверка на колво одинаковых операторов
      return null;
    }

    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }

    int a1 = 0, a2 = 0;
    String x = "";
    a1 = Integer.parseInt((vmas[0]));
    a2 = Integer.parseInt(vmas[1]);
    if (a2 <= 0 || a2 > 10) {
      return null;
    } //проверка на условие значения цифр
    if (a1 <= 0 || a1 > 10) {
      return null;
    }//проверка на условие значения цифр
    int sum = a1 / a2;
    x = x + sum;
    if (rab.equals("R")) {
      x = atr(x);
    }
    return x;
  }

  //Перевод Араб в Рим
  private static String atr(String inputString) {

    String d = "1 I 2 II 3 III 4 IV 5 V 6 VI 7 VII 8 VIII 9 IX 10 X 11 XI 12 XII 13 XIII 14 XIV 15 XV 16 XVI 17 XVII 18 XVIII 19 XIX 20 XX 21 XXI 22 XXII 23 XXIII 24 XXIV 25 XXV 26 XXVI 27 XXVII 28 XXVIII 29 XXIX 30 XXX 31 XXXI 32 XXXII 33 XXXIII 34 XXXIV 35 XXXV 36 XXXVI 37 XXXVII 38 XXXVIII 39 XXXIX 40 XL 41 XLI 42 XLII 43 XLIII 44 XLIV 45 XLV 46 XLVI 47 XLVII 48 XLVIII 49 XLIX 50 L 51 LI 52 LII 53 LIII 54 LIV 55 LV 56 LVI 57 LVII 58 LVIII 59 LIX 60 LX 61 LXI 62 LXII 63 LXIII 64 LXIV 65 LXV 66 LXVI 67 LXVII 68 LXVIII 69 LXIX 70 LXX 71 LXXI 72 LXXII 73 LXXIII 74 LXXIV 75 LXXV 76 LXXVI 77 LXXVII 78 LXXVIII 79 LXXIX 80 LXXX 81 LXXXI 82 LXXXII 83 LXXXIII 84 LXXXIV 85 LXXXV 86 LXXXVI 87 LXXXVII 88 LXXXVIII 89 LXXXIX 90 XC 91 XCI 92 XCII 93 XCIII 94 XCIV 95 XCV 96 XCVI 97 XCVII 98 XCVIII 99 XCIX 100 C ";
    String[] rc = d.split(" ");
    String x;
    int index = 0;
    int ravno = Integer.parseInt(inputString);
    index = (ravno * 2 - 1);
    x = "" + rc[index];
    return x;
  }

  //Перевод Рим в Араб
  private static String rta(String inputString) {
    String d = "1 I 2 II 3 III 4 IV 5 V 6 VI 7 VII 8 VIII 9 IX 10 X 11 XI 12 XII 13 XIII 14 XIV 15 XV 16 XVI 17 XVII 18 XVIII 19 XIX 20 XX 21 XXI 22 XXII 23 XXIII 24 XXIV 25 XXV 26 XXVI 27 XXVII 28 XXVIII 29 XXIX 30 XXX 31 XXXI 32 XXXII 33 XXXIII 34 XXXIV 35 XXXV 36 XXXVI 37 XXXVII 38 XXXVIII 39 XXXIX 40 XL 41 XLI 42 XLII 43 XLIII 44 XLIV 45 XLV 46 XLVI 47 XLVII 48 XLVIII 49 XLIX 50 L 51 LI 52 LII 53 LIII 54 LIV 55 LV 56 LVI 57 LVII 58 LVIII 59 LIX 60 LX 61 LXI 62 LXII 63 LXIII 64 LXIV 65 LXV 66 LXVI 67 LXVII 68 LXVIII 69 LXIX 70 LXX 71 LXXI 72 LXXII 73 LXXIII 74 LXXIV 75 LXXV 76 LXXVI 77 LXXVII 78 LXXVIII 79 LXXIX 80 LXXX 81 LXXXI 82 LXXXII 83 LXXXIII 84 LXXXIV 85 LXXXV 86 LXXXVI 87 LXXXVII 88 LXXXVIII 89 LXXXIX 90 XC 91 XCI 92 XCII 93 XCIII 94 XCIV 95 XCV 96 XCVI 97 XCVII 98 XCVIII 99 XCIX 100 C ";
    String[] rc = d.split(" ");
    String a = "";
    for (int i = 1; i < rc.length; i++) {
      if (inputString.equals(rc[i])) {
        a = "" + (i / 2 + 1);
        inputString = a;
        break;
      }

    }
    return inputString;
  }
}

class MyException extends Exception {
}