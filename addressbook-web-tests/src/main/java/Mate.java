import java.util.ArrayList;
public class Mate {
  public static void main(String[] args) {
    int[] a = {4, 6, 7, 1, 3};
    int[] b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 8};
    int[] c = {4, 6, 7, 1, 3};
    int[] d = {4, 6, 7, 1, 3};
    // incrementer(c);
   /* redKnight(-10, 4);
    redKnight(0, -18);
    redKnight(0, 7);
    redKnight(1, 6);
    redKnight(1, 5);
    */
    getVowels("asdfghjkliu");
  }
public static String getVowels(String input) {
    // WRITE YOUR CODE BELOW THIS LINE
    if(input==null){return null;}
    char [] g = input.toCharArray();
    String a="";
    for (char i:g)
    {
      if(i=='a'){a=a+i;continue;}
      if(i=='e'){a=a+i;continue;}
      if(i=='o'){a=a+i;continue;}
      if(i=='u'){a=a+i;continue;}
      if(i=='y'){a=a+i;continue;}
      if(i=='i'){a=a+i;continue;}

    }
  System.out.println(a);
    return a;
    // WRITE YOUR CODE ABOVE THIS LINE
  }
}

/*
�� ������ ����� �������, ������� �������� � ���������� ��������� ������� �� ������ ���������� ���������.

��� ��������������� ������ (��� ������) ������������� ���. �������� ������ ���� ������������ ���������� �����, ��������� � ������� (������ �������) � ���������� �����, ��������� �� �������� (������ �������) �� ���������� ���������.

���� ������ - ������� ���������� �����, ������� ��� ��� ��������� � �������� ����� ��������� ���������� ��������� (����� ���������� �������). �������� �� ��, ��� ��� ��������� ��������� ��������, ������� �� ���� � ��������� ���� ��� ��� ��������� � ��������, � ���, ��������, ��� ����: D

��������� �� �������� �������.

������ � ����, ��� �������� ������� �����������, ��� ���������� ����� � �������� ������> = 0. ����� �������, ������������ ����� ����� �� ����� ���� �������������.

������ �������� � ������ ������� ����� ����� ����� 0, ��� ��� ������� ���� �� ������ ���������� ���������.
* */