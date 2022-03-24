package hws.hw2;


/*
Suppose I have a double matrix stored in an array of arrays.
Write two nested enhanced for loops to print out the values in the matrix,
and skip values that are in [3,4) or [5,6] without using a continue or break statement or a label.
 */
public class PrintDoubleMatrix {
    public static void main(String[] args) {
        double[][] matrix = new double[][]{{1.0, 2.0, 3.5, 4.2},
                {2.7, 5.4, 4.4, 6.6},
                {4.9, 4.1, 4.8, 4.4, 3.3}};

        printMatrix(matrix);
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] rows : matrix) {
            for (double values : rows) {
                if (values < 3.0 || values >= 4.0 && values < 5.0 || values > 6.0) {
                    System.out.print(values + " ");
                }
            }
            System.out.println();
        }
    }
}
