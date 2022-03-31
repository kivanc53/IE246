package lectures.l7;

import java.util.Random;

public class Die {
    public int outcome;

    public Die(Random r) {

        // random [0,1)
        // x 6 -> [0,6)
        // ceil (0,1]-> 1 (1,2]->2... (5,6)->6

        this.outcome = (int) Math.ceil(Math.random() * 6);

        // floor of 2.9 is 2
        // ceiling of 2.1 is 3

        //             [0,1,2,3,4,5] -> [1,2,3,4,5,6]
        this.outcome = r.nextInt(6) + 1;

    }
}
