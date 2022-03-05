package hws.hw1;

public class DrawRectangle {
    public static void main(String[] args) {
        drawRectangle();
    }

    public static void drawRectangle() {
        String[] array = new String[]{"3", "4", "-onlyBorderLine"};

        int noRows = Integer.parseInt(array[0]);
        int noCols = Integer.parseInt(array[1]);

        if (noCols <= 0 || noRows <= 0) {
            System.out.println("Please provide two positive numbers.");
            return;
        }

        if (array.length < 3) {
            for (int row = 0; row < noRows; row++) {
                for (int col = 0; col < noCols; col++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } else if (array[2].equals("-onlyBorderLine")) {
            for (int row = 0; row < noRows; row++) {
                if (row == 0 || row == noRows - 1) {
                    for (int col = 0; col < noCols; col++) {
                        System.out.print("-");
                    }
                    System.out.println();
                } else {
                    for (int col = 0; col < noCols; col++) {
                        if (col == 0 || col == noCols - 1) {
                            System.out.print("|");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        } else {
            System.out.println("Usage: Use it with two arguments only for a complete rectangle, or use -onlyBorder as the last argument.");
        }
    }
}
