//Ты можешь добавлять свои импорты

//решение должно содержать данный класс
class Main {
  public static void main(String[] args) {
    String[] in = {"IV-VI", "II- I", "1+I", "      I    + I    ", " 4 + 3,5 ", " 4.5 + 3 ", "     9 - 10       ", "  -1   ", "   4  -  1   ", "1 ", "2-1", "10+11", "1 - 2", "2*3", "2*0", "3/2", "4/0", "I+V", "VI-IV", "IX*V", "X/VII", "1+1+2", "1-2+2", "", "III+XIII", "XI+XV"};

    for (String s : in) {
      System.out.println("Входящие данные: " + s + " расчитанные данные = " + calc(s));
    }
  }

  //Решение должно содержать данный метод
  public static String calc(String inputString) {
    String t = inputString;
    inputString = inputString.toUpperCase();//Регистр вверх
    inputString = chist(inputString);//чистим от пробелов и проверяем на точки и запятые
    String ravno = "";

    try {

      ravno = ravno(inputString, romOrArab(inputString));
    } catch (Exception e) {
      System.err.println("исключение операций по (" + t + ")");
    }

    return ravno;
  }

  //чистим от пробелов
  private static String chist(String x) {
    String z = "";
    char[] y = x.toCharArray();
    for (char c : y) {
      if (c == '.' || c == ',') {
        return "-1";
      }
      if (c != ' ') {
        z = z + c;
      }
    }
    return z;
  }

  //Равно вывод, завершающий метод
  private static String ravno(String input, String deystvie[]) throws Exception {

    String ravno = "";
    if (deystvie[2].equals("P")) {
      ravno = sum(input, deystvie[3]);
    }

    if (deystvie[2].equals("M") && romOrArab(input)[3].equals("A")) {
      ravno = minus(input, deystvie[3]);
    }
    if (deystvie[2].equals("U")) {
      ravno = umn(input, deystvie[3]);
    }
    if (deystvie[2].equals("D")) {
      ravno = del(input, deystvie[3]);
    }
    if (deystvie[2].equals("M") && Integer.parseInt(rta(romOrArab(input)[0])) > Integer.parseInt(rta(romOrArab(input)[1])) && romOrArab(input)[3].equals("R")) {
      ravno = minus(input, deystvie[3]);
    } else {
      new Exception();
    }
    return ravno;
  }

  //Проверка какие операторы внутри и цифры
  //Проверка Араб или Рим
  private static String[] romOrArab(String inputString) {
    String[] p = inputString.split("\\+");
    String[] m = inputString.split("\\-");
    String[] u = inputString.split("\\*");
    String[] d = inputString.split("/");
    String[] vid = new String[4];
    if (p.length == 2) {
      vid[0] = p[0];
      vid[1] = p[1];
      vid[2] = "P";
      vid[3] = vid(inputString);
    }
    if (m.length == 2) {
      vid[0] = m[0];
      vid[1] = m[1];
      vid[2] = "M";
      vid[3] = vid(inputString);
    }
    if (u.length == 2) {
      vid[0] = u[0];
      vid[1] = u[1];
      vid[2] = "U";
      vid[3] = vid(inputString);
    }
    if (d.length == 2) {
      vid[0] = d[0];
      vid[1] = d[1];
      vid[2] = "D";
      vid[3] = vid(inputString);
    }
    return vid;
  }

  //            Вид цифр араб или рим
  private static String vid(String v) {
    String vid = "R";
    for (int i = 0; i < 10; i++) {
      char mi = (char) (i + '0');
      if (v.charAt(0) == mi) {
        vid = "A";
        break;
      }
    }
    return vid;
  }

  // Сумма
  private static String sum(String inputString, String rab) throws Exception {

    String[] vmas = inputString.split("\\+");//в масив 2 числа или более

    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }//перевод из рима в араб если необходимо

    int a1 = 0, a2 = 0;
    String x = "";
    aprim(vmas[0], vmas[1], inputString);
    a1 = Integer.parseInt(vmas[0]);
    a2 = Integer.parseInt(vmas[1]);

    int sum = a1 + a2;
    x = x + sum;
    if (rab.equals("R")) {
      x = atr(x);
    }
    return x;
  }

  // Разность
  private static String minus(String inputString, String rab) throws Exception {

    String[] vmas = inputString.split("-");//в масив 2 значения или более

    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }//перевод из рима в араб
    aprim(vmas[0], vmas[1], inputString);
    int a1 = 0, a2 = 0;
    String x = "";
    a1 = Integer.parseInt((vmas[0]));
    a2 = Integer.parseInt(vmas[1]);
    int sum = a1 - a2;

    x = x + sum;
    if (rab.equals("R")) {
      x = atr(x);
    }
    return x;
  }

  // Произведение
  private static String umn(String inputString, String rab) throws Exception {

    String[] vmas = inputString.split("\\*");//в масив 2 значения или более
    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }
    aprim(vmas[0], vmas[1], inputString);
    int a1 = 0, a2 = 0;
    String x = "";
    a1 = Integer.parseInt((vmas[0]));
    a2 = Integer.parseInt(vmas[1]);

    int sum = a1 * a2;
    x = x + sum;
    if (rab.equals("R")) {
      x = atr(x);
    }
    return x;
  }

  // Деление
  private static String del(String inputString, String rab) throws Exception {

    String[] vmas = inputString.split("/");//в масив 2 значения или более

    if (rab.equals("R")) {
      vmas[0] = rta(vmas[0]);
      vmas[1] = rta(vmas[1]);
    }
    aprim(vmas[0], vmas[1], inputString);
    int a1 = 0, a2 = 0;
    String x = "";
    a1 = Integer.parseInt((vmas[0]));
    a2 = Integer.parseInt(vmas[1]);
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

  //проверка рим + араб на исключение
  private static void aprim(String a, String b, String c) throws Exception {

    if (Integer.parseInt(a) >= 1 && Integer.parseInt(b) >= 1 && Integer.parseInt(a) <= 10 && Integer.parseInt(b) <= 10) {
    } else {
      throw new Exception();
    }
  }

}
