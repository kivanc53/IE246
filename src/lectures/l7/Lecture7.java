package lectures.l7;

import java.util.ArrayList;
import java.util.Random;

public class Lecture7 {
    public static void main(String[] args) {

        Sport s = new Sport();
        s.durationInMinutes=60;
        s.isTeamSport=true;
        s.setName("Rugby");


        Sport t = new Sport();
        t.setName("Soccer");
        t.durationInMinutes = 90;

        Sport[] allSports = new Sport[2];
        allSports[0]=s;
        allSports[1]=t;

        ArrayList<Sport> someSports = new ArrayList<>();
        someSports.add(t);
        someSports.add(s);

        printArrayList(allSports); // this error is addresses by overloading method printArrayList
        // overloading -> same method name can be used with alternative input types

        someSports.remove(0);
        someSports.remove(0);

        System.out.println("After removal");

        printArrayList(someSports);

        // Let's populate some sports...
        Sport n = new Sport("Soccer", 90, true, SportType.withRoundBall, true, true); // constructor call
        Sport b = new Sport("Basketball", 48, true, SportType.withRoundBall, true, false);
        Sport r = new Sport("Rugby", 60, false, SportType.withNonRoundBall, true);
        Sport h = new Sport("Ice Hockey", 60, false, SportType.withPuck, true);
        Sport tt = new Sport("Tennis", -1, true, SportType.withRoundBall, false);
        someSports.add(tt);
        someSports.add(n);
        someSports.add(b);
        someSports.add(r);
        someSports.add(h);
        n.durationInMinutes=99999; // reflected in the output
        printArrayList(someSports);

        // Rolling two dice: die, pl

        // What is the probability that you observe a sum strictly less than 9?
        // What is the approximate probability?

        int numberOfTrials = 999999;
        int numberOfSuccesses = 0;
        Random rng = new Random();
        rng.setSeed(3);

        for(int i=0; i<numberOfTrials;i++)
        {
            numberOfSuccesses = numberOfSuccesses+isLessThan(9,2, rng);
        }

        System.out.println("The probability is "+ ((double)numberOfSuccesses/numberOfTrials));

    }

    private static int isLessThan(int bound, int numberOfDice, Random rng) {
        int sum=0;

        Die[] dice = new Die[numberOfDice];

        for(int i=0; i<dice.length;i++)
            dice[i] = new Die(rng);

        System.out.println(dice[0].outcome+" "+dice[1].outcome);

        for(Die d:dice)
        {
            sum=sum+d.outcome;
        }

        int result=0;
        if(sum<bound)
            result=1;
        return result;
    }

    private static void printArrayList(ArrayList<Sport> x) {
        for(Sport w : x)
            System.out.println(w.getName()+"\t Duration -> "+w.durationInMinutes);
    }
    private static void printArrayList(Sport[] x) {
        for(Sport w : x)
            System.out.println(w.getName()+"\t Duration -> "+w.durationInMinutes);
    }
}
