package recitations.rec1;


/*
    Given two non-negative int values, print true if they have the same last digit, such as with 27 and 57.
 */
public class Problem3 {
    public static void main(String[] args) {
        int a = 27, b = 37;
        problem3(a, b);
    }

    public static void problem3(int a, int b) {
        System.out.println(a % 10 == b % 10);
    }
}
