package recitations.rec2;


/*
    Given a list of integers taken with java call, find the summation of even numbers that are divisible by 5
 */
public class Problem6 {
    public static void main(String[] args) {
        int[] array = new int[]{10, 5, 15, -2};

        System.out.println(problem6(array));
    }

    public static int problem6(int[] array) {
        int sum = 0;
        for (int j : array)
            if (j % 5 == 0 && j % 2 == 0)
                sum += j;

        return sum;
    }
}
