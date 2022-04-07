package recitations.rec7;

/*
1) Suppose that we are designing a box loading system and goods are automatically loaded to multiple boxes.
Each good has a weight and assume that the boxes are uncapacitated. When loading is finished we want to calculate
different statistics for each box and want to see which box has an average weight of goods below a certain threshold.
Design and code a class that would track weights of goods in different boxes and calculates max,
min avg weight of goods in each box. A reporting functionality should report these statistics and point out boxes
with average weight of good below the threshold. Your class will take this threshold value as a parameter in its constructor.
 Your definitions should work with the following code:

public static void main(String[] args) {
      BoxTracker boxTracker = new BoxTracker(7);
      boxTracker.addGoods(1, 7); //adds a good with a weight of 7 to box 1
      boxTracker.addGoods(1, 9);
      boxTracker.addGoods(1, 11);

      boxTracker.addGoods(2, 3);
      boxTracker.addGoods(2, 5);
      boxTracker.addGoods(2, 7);

      boxTracker.addGoods(1, 2);

      boxTracker.report();

}

The constructor initializes the threshold value, addGoods(int, int) method accounts goods and boxes and
 finally report() method reports the required statistics and boxes under the threshold  value:
Box1:
Min: 7
Max: 11
Mean: 9

Box2
Min: 3
Max: 7
Mean: 5

Boxes under threshold:
Box2

Write a class that would give the above output with correct functionalities. Boxes will be in consecutive numbers.
Meaning for example there will not be Box 1 and 3 and not 2. But the goods can be loaded in any order.
 */

public class Problem1 {
}
