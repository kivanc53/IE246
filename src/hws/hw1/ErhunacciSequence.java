package hws.hw1;

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
