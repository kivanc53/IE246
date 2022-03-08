package recitations.rec1;


/*
    Given 2 ints, a and b, return their sum.
    However, sums in the range 10..19 inclusive, are forbidden, so in that case just return 20.
 */
public class Problem5 {
    public static void main(String[] args) {
        int a = 16, b = 10;
        System.out.println(problem5(a, b));
    }

    public static int problem5(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 19)
            return 20;
        else
            return sum;
    }
}
