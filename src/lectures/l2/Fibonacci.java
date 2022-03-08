package lectures.l2;

public class Fibonacci {
    public static void main(String[] args) {
        int value = 17;
        System.out.printf("First %d value of fibonacci numbers are: ", value);
        fibonacci(value);
    }

    public static void fibonacci(int value) {
        int first = 1, second = 1, temp;
        System.out.print(first + " " + second);
        for (int i = 2; i < value; i++) {
            temp = first;
            first = second;
            second += temp;
            System.out.print(" " + second);
        }
        System.out.println();
    }
}
