package lectures.l2;

public class Factorial {
    public static void main(String[] args) {
        int value = 5;
        System.out.printf("%d! = %d", value, factorial(value));
    }

    public static int factorial(int value) {
        int result = 1;
        for (int i = 1; i <= value; i++)
            result *= i;
        return result;
    }
}
