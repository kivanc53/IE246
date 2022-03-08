package recitations.rec2;


/*
    Given an array of ints taken with java call,
    print a new array with the elements in reverse order,
    so {1, 2, 3} becomes {3, 2, 1}.
 */
public class Problem5 {
    public static void main(String[] args) {
        int[] array = new int[]{3, 5, 8, -2};
        problem5(array);
    }

    public static void problem5(int[] array) {

        //1.yol
        int[] array2 = new int[array.length];
        for (int i = 0; i < array.length; i++)
            array2[i] = array[array.length - 1 - i];
        System.out.println(java.util.Arrays.toString(array2));

        //2.yol
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.println(java.util.Arrays.toString(array));
    }
}
