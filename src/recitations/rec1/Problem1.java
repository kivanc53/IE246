package recitations.rec1;


/*
    Given 2 int values and a boolean negative value, print true if one is negative and one is positive.
    Except if the parameter "negative" is true, then print true only if both are negative.
 */

public class Problem1 {
    public static void main(String[] args) {
        int a = -1, b = -2;
        boolean c = true;
        problem1(a, b, c);
    }

    public static void problem1(int a, int b, boolean c) {
        if (a < 0 && b > 0 || a > 0 && b < 0)
            System.out.println("birinci true");
        else if (a < 0 && b < 0 && c)
            System.out.println("ikinci true");
    }
}
