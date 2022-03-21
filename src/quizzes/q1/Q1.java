package quizzes.q1;

/*
You cannot use scanner. You cannot import any packages before the main method. ok
Create two arrays of size 20. ok
The first array should be an integer array, whose name is your first name, ok
and the second array should be a boolean array, whose name is your last name. ok

Of course, you need to replace the Turkish characters with their associated Latin characters (e.g., kundakcioglu). ok
Place the first 20 numbers in an Erhunacci sequence in the first array, which was an integer array. ok
Numbers in Erhunacci sequence satisfy the following property: the n-th number is (2 times n-1st) + (5 times n-2nd) - (n-3rd).ok
The first 3 numbers are 9 0 and 3. So the fourth number should be 2*3 + 5*0 - 9 = -3. ok
Of course, the first number goes to index zero inside the array. ok

Next, for each number check out if they are positive and divisible by 3.
If so, the associated entry on the second boolean array must be true.
Otherwise, it should be false. So they look as follows:

erhun = [9 0 3 -3 ...]

kundakcioglu = [true false true false ...]
 */
public class Q1 {
    public static void main(String[] args) {
        int[] kivanc = new int[20];
        boolean[] yilmaz = new boolean[20];

        addErhunacciNumbersToArray(20, kivanc);
        check(kivanc, yilmaz);

        System.out.println(java.util.Arrays.toString(kivanc));
        System.out.println(java.util.Arrays.toString(yilmaz));
    }

    public static void check(int[] kivanc, boolean[] yilmaz) {
        for (int i = 0; i < kivanc.length; i++)
            yilmaz[i] = kivanc[i] > 0 && kivanc[i] % 3 == 0;
    }

    public static void addErhunacciNumbersToArray(int value, int[] array) {
        int a = 9, b = 0, c = 3, d;
        array[0] = a;
        array[1] = b;
        array[2] = c;

        for (int i = 3; i < value; i++) {
            d = 2 * c + 5 * b - a;
            array[i] = d;
            a = b;
            b = c;
            c = d;
        }
    }
}
