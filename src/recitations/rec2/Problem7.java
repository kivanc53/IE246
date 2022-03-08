package recitations.rec2;


/*
    Given an array of integers taken with java call,
    write a code that prints the number if the array repeats a number "exactly" twice somewhere,
    and prints "No numbers are repeated exactly twice" otherwise.
 */
public class Problem7 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 10, 5, 15, -2, 10};
        problem7(array);
    }

    public static void problem7(int [] array) {
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            int count = 0;
            for (int j = i + 1; j < array.length; j++){
                if (array[i] == array[j])
                    count++;
            }
            if (count == 2) {
                System.out.println(array[i]);
                flag = false;
            }
        }

        if (flag)
            System.out.println("No numbers are repeated exactly twice");
    }
}
