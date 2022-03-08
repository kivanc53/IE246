package recitations.rec1;


/*
    For an integer value n from the user and print a square with an edge length of n with *'s
 */
public class Problem7 {
    public static void main(String[] args) {
        int value = 3;
        problem7(value);
    }

    public static void problem7(int value) {
        for (int i = 0; i < value; i++) {
            for (int j = 0; j < value; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
