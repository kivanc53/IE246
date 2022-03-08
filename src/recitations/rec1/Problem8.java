package recitations.rec1;


/*
    Given two integer values a and b, print the b'th power of a

 */

public class Problem8 {
    public static void main(String[] args) {
        int a = 2, b = 3;
        problem8(a, b);
    }

    public static void problem8(int a, int b) {
        System.out.println(Math.pow(a, b));
    }
}
