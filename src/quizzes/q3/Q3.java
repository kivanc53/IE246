package quizzes.q3;

import java.util.ArrayList;
import java.util.Random;

/*
(10 pts) Provide a class named Die, ok
that takes a Random object, the number of faces in a die,and a seed number in its constructor. ok
Depending on the number of faces, the possible outcomes change, ok
but they always start from 1 with increments of one: for example in a 10 face die, the outcomes ok
can be 1,2,3,4,5,6,7,8,9,10. For a 5 face die, the outcomes can be 1,2,3,4,5. ok
The seed number sent to the constructor should be the random number generator seed number ok

The Die class should have a method that returns the outcome for a die roll, ok
and one that returns how many rolls are required to observe a specific number on the die face. ok
The number is assumed to be a number that exists on the faces of the die, ok
so you do not need to specifically check if it is among the possible outcomes. ok
I should be able to do the following: ok
Random random = new Random(); ok
int numberOfFaces = 10; ok
int seedNumber = 13; ok
Die die = new Die(random, numberOfFaces, seedNumber); ok
int outcome = die.roll(); // outcome becomes 1,2,3,4,5,6,7,8,9, or 10 if the number of faces is 10 ok
int rollNo = die.noOfRollsUntil(6); // count how many rolls were required until the outcome 6 appears. ok
//Checking if 6 is on one of the die faces is not necessary, we assume the input will always be one of the outcomes of the die.ok
Important Note: You "have to" use your roll method inside your noOfRollsUntil method. ok

(BONUS 5 pts)The Die class should have another method that returns the outcome for a biased die roll. ok
In a biased roll, each number is not equally likely like an ordinary die. ok
A biased roll has each outcome show up with a probability that is proportional to the outcome value.
That is, the probability of an 8 is twice as much as a 4, four times as much as a 2.
So the most likely outcome is the number of faces, and the least likely outcome is a 1. I should be able to do the following:
int outcome = die.biasedRoll(); // outcome takes values with defined probabilities
 */
public class Q3 {
    public static void main(String[] args) {
        Random random = new Random();
        int numberOfFaces = 10, seedNumber = 13;
        Die die = new Die(random, numberOfFaces, seedNumber);
        int outcome = die.roll(), rollNo = die.noOfRollsUntil(6), outcomeForBiased = die.biasedRoll();
        System.out.printf("outcome is %d and roll number is %d and outcome for biased roll %d", outcome, rollNo, outcomeForBiased);
    }
}

class Die {
    public Random random;
    int numberOfFaces, seedNumber;

    public Die(Random random, int numberOfFaces, int seedNumber) {
        random.setSeed(seedNumber);
        this.random = random;
        this.numberOfFaces = numberOfFaces;
        this.seedNumber = seedNumber;
    }

    public int roll() {
        return this.random.nextInt(numberOfFaces) + 1;  // outcome becomes 1 to numberOfFaces.
    }

    public int noOfRollsUntil(int value) {
        int count = 0;
        do {
            count++;
        } while (value != this.roll());
        return count;
    }

    public int biasedRoll() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= numberOfFaces; i++)
            for (int j = 0; j < i; j++) {
                list.add(i);
            }
        return list.get(random.nextInt(list.size()));
    }
}
