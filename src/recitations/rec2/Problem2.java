package recitations.rec2;


/*
    Write a code that takes in an integer from the user with java call and prints if it is prime or not
 */

public class Problem2 {
    public static void main(String[] args) {
        problem2();
    }

    public static void problem2() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter a number: ");
        System.out.println(isPrime(Integer.parseInt(scanner.nextLine())));
    }

    public static boolean isPrime(int val) {
        if (val <= 1)
            return false;

        if (val % 2 == 0)
            return val == 2;

        if (val % 3 == 0)
            return val == 3;

        if (val % 5 == 0)
            return val == 5;

        if (val % 7 == 0)
            return val == 7;

        int count = 0;

        for (int i = 11; i * i <= val; i += 2) {
            ++count;
            if (val % i == 0)
                return false;
        }

        return true;
    }
}
