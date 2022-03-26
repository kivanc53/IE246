package quizzes.q2;


/*
    You cannot use scanner. You cannot import any packages before the main method.
    (10 pts) Write a method named divisible that takes an integer array (say anArray) and an integer (say d),
    and prints out the elements in anArray that are divisible by d.
    Make sure the original input variables are not altered/changed.
    If anArray=[3 4 6] and d=2, the method should print out 4 6.
 */
public class Q2 {
    public static void main(String[] args) {
        int[] anArray = new int[]{3, 4, 6};
        int d = 2;
        divisible(anArray, d);

    }

    public static void divisible(int[] anArray, int d) {
        if (anArray.length > 0 && d != 0) {
            boolean a = true;
            for (int j : anArray) {
                if (j % d == 0) {
                    System.out.print(j + " ");
                    a = false;
                }
            }
            if (a)
                System.out.println("anArray has not any value divisible by " + d);
        } else {
            System.out.println("anArray has not any value! Or d cannot be 0!");
        }
    }
}
