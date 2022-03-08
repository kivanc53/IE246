package recitations.rec2;


/*
    Given a list of integers with java call, if there is any number divisible by 4 print its order.
    If not print "No divisible by 4".
 */
public class Problem3 {
    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 7, 4};
        problem3(array);
    }

    public static void problem3(int[] array) {
        boolean flag = true;
        for (int j : array) {
            if (j % 4 == 0) {
                System.out.println(j);
                flag = false;
            }
        }
        if (flag)
            System.out.println("No divisible by 4");
    }
}
