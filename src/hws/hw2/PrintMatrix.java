package hws.hw2;


/*
Suppose I have an integer matrix stored in an array of arrays.
Write two nested enhanced for loops to print out the values in the matrix,
and stop printing the matrix when you come across a value in [3,4] without using a continue or break statement or a label.
 */
public class PrintMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{{1, 2, 6, 7},
                {2, 5, 6, 6},
                {1, 4, 4, 4, 3}};

        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int values : rows) {
                if (values <= 4 && values >= 3) {
                    return;
                }
                System.out.print(values + " ");
            }
            System.out.println();
        }
    }
}
