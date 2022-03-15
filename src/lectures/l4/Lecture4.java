package lectures.l4;

//enhanced for loop = for-each loop

public class Lecture4 {
    public static void main(String[] args) {
        // Create a matrix 2D array
        double[][] matrix = new double[5][]; // array of arrays
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new double[6];// you can create different sized arrays at each iteration
        }

        // Create entries in this 5x6 matrix
        // in a way that each entry is
        // the sum of it's row and column index - suppose indexing starts with zero

        // 0 1 2 3 4 5
        // 1 2 3 4 5 6
        // 2 3 4 5 6 7
        // ...

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i + j;
            }
        }

        System.out.println("Done!");

        // Enhanced-for loop
        int[] anExample = {1, 12, 13, 4, 5};

        for (int i = 0; i < anExample.length; i++) // iterator -> index
        {
            System.out.print(anExample[i] + " "); // third time, i=2, anExample[i]=13
        }

        System.out.println();

        // enhanced for loop iterates through the entries directly, not indices
        // anExample -> [1 12 13 4 5]
        // for each ENTRY

        for (int e : anExample) // for each e in anExample, print out e
        {
            System.out.print(e + " "); // third time e=13
        }

        System.out.println();

        // print out matrix called matrix here using only 2 enhanced for loops
        for (double[] row : matrix) {
            for (double entry : row) {
                System.out.print(entry + " ");
            }
            System.out.println();
        }

        String[] l = {"IE", " 246"};
        for (String something : l)
            System.out.print(something); // a one liner example
        System.out.println();


        // Categorical information such as smoker/nonsmoker, m/t/w/r/f/s/su,
        // months of the year, freshman/sophmore/junior/senior etc.

        // ENUM : enumeration
        // january, jan, janu, januareyar,

        Year myYear;
        myYear = Year.Junior;


        if (myYear.equals(Year.Junior)) {
            System.out.println("I'm a junior!");
        } else {
            System.out.println("I'm not a junior!");
        }

        // Often, enums are used with switch statements...
        // Erhun Hoca never uses switch, and uses if only...

        System.out.println("Switch statement example:");

        switch (myYear) {
            case Freshman:
                System.out.println("I will take first year classes.");
            case Sophmore:
                System.out.println("I will take second year classes.");
            case Junior:
                System.out.println("I will take third year classes.");
            case Senior:
                System.out.println("I will take fourth year classes.");
        }

        switch (myYear) {
            case Freshman:
                System.out.println("I am a freshman.");
                break;
            case Sophmore:
                System.out.println("I am a sophmore.");
                break;
            case Junior:
                System.out.println("I am a junior.");
                break;
            case Senior:
                System.out.println("I am a senior.");
                break;
            default: // whatever else is your case
                System.out.println("I don't go to school");
        }

        // While & do-while

        // Print out numbers from -5, up to 10, both inclusive
        // for loops are good if you know how many times to iterate

        int a = 5;
        while (a <= 10) {
            System.out.print(a + " ");
            a = a + 1;
        }
        System.out.println("The password for the files on Github: 1903 (except for week 2 which was I guess BJK1903)");
        a = 12;
        do {
            System.out.print(a + " ");
            a = a + 1;
        } while (a <= 10);

        System.out.println("\nExample:");

        // Compute the sum of digit values of a given integer.
        // Ex: 872 -> 8+7+2 = 17
        int x = 9445;
        // Pseudocode:
        // sum=0
        // while (there is some number) {
        // find the last digit's value and add to sum  -- x%10
        // remove the last digit -- x/10
        // }

        int sum = 0;
        while (x != 0) {
            sum = sum + x % 10;
            x = x / 10;
        }
        System.out.println(sum);

        System.out.println("\nBack to matrix printing:");
        for (double[] row : matrix) {
            for (double entry : row) {
                System.out.print(entry + " ");
            }
            System.out.println();
        }

        System.out.println("Suppose I'd like to stop printing a row, if the value is greater than 2");
        for (double[] row : matrix) {
            for (double entry : row) {
                if (entry > 2) {
                    break; // break takes you out of the innermost loop.
                }
                System.out.print(entry + " ");
            }
            System.out.println();
        }

        System.out.println("Suppose I'd like to stop printing altogether (the matrix) when I see a value in [3,4]");

        print:
        for (double[] row : matrix) {
            for (double entry : row) {
                if (entry <= 4 && entry >= 3) {
                    break print; // you can label code blocks and break accordingly
                    // In the industry labeling is not preferred.
                    // HW question: Try to solve this problem without break and label.
                }
                System.out.print(entry + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println("Suppose I'd like to skip values that are in [3,4]");
        for (double[] row : matrix) {
            for (double entry : row) {
                if (entry <= 4 && entry >= 3) {
                    continue;
                }
                System.out.print(entry + " ");
            }
            System.out.println();
        }
        System.out.println("Suppose I'd like to skip values that are in [3,4] without continue statement");
        for (double[] row : matrix) {
            for (double entry : row) {
                boolean printThis = false;
                if (!(entry <= 4 && entry >= 3)) {
                    printThis = true;
                }
                if (printThis) {
                    System.out.print(entry + " ");
                }
            }
            System.out.println();
        }


    }

    enum Year {
        Freshman, Sophmore, Junior, Senior, noSchool, working, teaching
    }
}
