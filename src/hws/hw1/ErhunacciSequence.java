package hws.hw1;


/*
        Print out first 100 numbers in an Erhunacci sequence.
        Numbers in Erhunacci sequence satisfy the following property: the n-th number is (2 times n-1st) + (3 times n-2nd) - (n-3rd).
        The first 3 numbers are 9 0 and 3. So the fourth number should be 2*3 + 3*0 - 9 = -3.
 */

public class ErhunacciSequence {
    public static void main(String[] args) {
        printErhunacciNumbers(100);
    }

    public static void printErhunacciNumbers(int value) {
        int a = 9, b = 0, c = 3, d;
        for (int i = 3; i < value; i++) {
            d = 2 * c + 3 * b - a;
            System.out.printf("%d th Erhunacci number is %d%n", i + 1, d);
            a = b;
            b = c;
            c = d;
        }
    }
}
