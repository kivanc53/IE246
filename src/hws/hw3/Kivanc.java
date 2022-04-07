package hws.hw3;

import java.util.ArrayList;
import java.util.Random;

public class Kivanc {
    public static void main(String[] args) {
        int tailCount = 5;
        int howMany = untilTails(tailCount);

//        Random random = new Random();
//        Coin coin = new Coin(random);

        System.out.printf("%d coin tosses are needed until there are %d tails", howMany, tailCount);
    }

    public static int untilTails(int value) {
        ArrayList<Coin> list = new ArrayList<>();
        Random random = new Random();

        do {
            Coin coin = new Coin(random);
            list.add(coin);
        } while (Coin.getTailCount() != value);

       // printArrayList(list);

        return list.size();
    }

    public static void printArrayList(ArrayList<Coin> list) {
        System.out.print("set of Coin objects: ");
        for (Coin coin : list)
            System.out.print(coin.isTail + " ");
        System.out.println();
    }
}

class Coin {    //heads = tura, tails = yazı
    public boolean isTail;
    public static int tailCount = 0;

    public Coin(Random random) {
        this.isTail = random.nextBoolean();
        if (this.isTail)
            tailCount++;
    }

    public static int getTailCount() {
        return tailCount;
    }
}