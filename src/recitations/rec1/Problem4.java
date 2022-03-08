package recitations.rec1;


/*
Given 2 ints, a and b, print true of one if them is 10 or if their sum is 10.
 */
public class Problem4 {
    public static void main(String[] args) {
        int a = 6, b = 10;
        problem4(a, b);
    }

    public static void problem4(int a, int b) {
        System.out.println(a == 10 || b == 10 || a + b == 10);
    }
}
