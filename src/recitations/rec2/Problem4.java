package recitations.rec2;


/*
    Write a code that reports the average of integers in a given sequence.
    The numbers are given with the java call. Let the name of the program be findAvg
 */
public class Problem4 {
    public static void main(String[] args) {
        problem4();
    }

    public static void problem4() {
        int[] array = new int[]{3, 5, 8, -2};
        findAvg(array);
    }

    public static void findAvg(int[] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        System.out.printf("Average of %s is %.2f", java.util.Arrays.toString(array), (double) sum / array.length);
    }
}
