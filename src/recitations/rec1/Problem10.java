package recitations.rec1;


/*
    Find the perfect numbers in range 1-100 (both inclusive) and print them
    Hint: A number is a perfect number if the summation of its divisors except for itself is equal to the number itself.
     E.g. 6 is a perfect number --> (1 + 2 + 3 = 6)
 */
public class Problem10 {
    public static void main(String[] args) {
        problem10();
    }

    public static void problem10() {
        for (int i = 1; i <= 100; i++)
            if (isPerfect(i))
                System.out.print(i + " ");
    }

    public static boolean isPerfect(int value) {
        int sum = 0;
        for (int i = 1; i <= value / 2; i++)
            if (value % i == 0)
                sum += i;
        return sum == value;
    }
}
