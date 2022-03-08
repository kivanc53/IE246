package lectures.l3;

public class Rectangle {
    public static void main(String[] args) {

        String [] str = new String[]{"3", "4", "-onlyBorder"};
        int noRows = Integer.parseInt(str[0]);
        int noCols = Integer.parseInt(str[1]);

        if (str.length < 3) // do entire rectangle, if there are only two arguments, e.g., 4 8
        {
            for (int row = 0; row < noRows; row++) {
                for (int col = 0; col < noCols; col++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        // To check string equality, use .equals method.
        else if (str[2].equals("-onlyBorder")) // if there are more then two arguments,
        // and if third (index is 2) argument is "-onlyBorder"
        // then do the following
        // if I run 4 8 -erhun -> ? do nothing
        {
            for (int row = 0; row < noRows; row++) {
                // while I'm drawing the rows, first and last row is complete
                // so if my row iterator is first or last, I ensure row is complete.
                // for others, I only need the first and last column as *
                // the rest must be spaces
                if (row == 0 || row == noRows - 1) // first or last row
                {
                    for (int col = 0; col < noCols; col++) {
                        System.out.print("*");
                    }
                    System.out.println();
                } else // this is others now, need the first and last column as *
                {
                    for (int col = 0; col < noCols; col++) {
                        // check if column iterator is first or last
                        if (col == 0 || col == noCols - 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        } else {
            System.out.println("Usage: Use it with two arguments only for a complete rectange, or use -onlyBorder as the last argument.");
        }
    }
}
