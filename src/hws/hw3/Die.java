package hws.hw3;

import java.util.Random;

public class Die {
    public Random random;

    public Die(Random random) {
        this.random = random;
    }

    public int roll() {
        return this.random.nextInt(6) + 1;
    }

    public int experiment(int value, int testCase) {
        int count = 0;
        for (int i = 0; i < testCase; i++) {
            if (value == this.roll())
                count++;
        }
        return count;
    }
}

class DieTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Random random = new Random();
        Die die = new Die(random);

        int outcome = die.roll(); // outcome becomes 1,2,3,4,5, or 6.
        System.out.println(outcome);

        int count = die.experiment(5, 10000); // count becomes how many 5's are observed among 10000 die rolls.
        System.out.println(count);
    }
}
