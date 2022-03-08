package recitations.rec1;


/*
    You are driving a little too fast, and a police officer stops you.
    Write code to compute the result, encoded as an int value: 0=no ticket, 1=small ticket, 2=big ticket.
    If speed is 60 or less, the result is 0. If speed is between 61 and 80 inclusive, the result is 1.
    If speed is 81 or more, the result is 2.
    Unless it is your birthday -- on that day, your speed can be 5 higher in all cases.
 */

public class Problem2 {
    public static void main(String[] args) {
        problem2(65, false);
    }

    public static void problem2(int speed, boolean birthday) {
        int result;
        if (birthday && speed <= 65 || speed <= 60)
            result = 0;
        else if (birthday && speed <= 85 || speed <= 80)
            result = 1;
        else
            result = 2;

        System.out.println(result);
    }
}
