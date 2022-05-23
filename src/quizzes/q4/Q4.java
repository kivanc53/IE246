package quizzes.q4;

/*
(5 pts) Create a Player class with member variables name and jersey number. Create two players with name and numbers as follows: ok

"Kobe Bryant", 24 ok

"Michael Jordan", 23 ok

Next, place these as keys of a Hashmap<Player, Integer>, where the integer "value" represents the total points scored. ok

Suppose that Kobe Bryant scored 33643 points, and Michael Jordan scored 32292 points. ok



(2 pts) Next, create a new Player object (say player3) that is identical to one of the earlier created players (same name and jersey number). ok
Now try to use player3 as a key and access the corresponding integer value (total points scored) for this player. ok



(3 pts) Can you access the player? If yes, explain how this worked. If not, explain why not. ok

Please provide your code and your explanations (commented out) for all questions in the same java file. ok
 */


import java.util.HashMap;

public class Q4 {
    public static void main(String[] args) {
        Test.run();
    }
}

class Test {
    public static void run() {
        //q1 start
        Player player1 = new Player("Kobe Bryant", 24);
        Player player2 = new Player("Michael Jordan", 23);

        HashMap<Player, Integer> hashMap = new HashMap<>();
        hashMap.put(player1, 33643);
        hashMap.put(player2, 32292);

        //q2 start
        Player player3 = new Player("Kobe Bryant", 24);
        System.out.printf("Information of %s are jersey number = %d and total score = %d%n", player3.getName(), player3.getJerseyNumber(), hashMap.get(player3));
        System.out.printf("Information of %s are jersey number = %d and total score = %d%n", player1.getName(), player1.getJerseyNumber(), hashMap.get(player1));

        //q3 start
        /*
        when we look at the example in q2, we can see that we can reach the information of player with this new object too.
        According to the my example, we can take the same name and jersey number with get methods because of having same information in the objects
        But if we want to take scoring information from hashmap, we can't take the scoring information with hashmap.get() method because
        every key in the hashmap is unique and we are giving the references of objects to hashmap. Therefore, objects is same but
        references are different. Because of this difference, hashmap cannot find the key which called "player3" and it cannot find value too.
        finally, it will give "null" to us. Also, in the method description it says for returns = "the value to which the specified key is mapped, or null if this map contains no mapping for the key"
         */
    }
}

class Player {
    private final String name;
    private final int jerseyNumber;

    public Player(String name, int jerseyNumber) {
        this.name = name;
        this.jerseyNumber = jerseyNumber;
    }

    public String getName() {
        return name;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }
}
