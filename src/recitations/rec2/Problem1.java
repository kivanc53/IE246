package recitations.rec2;


/*
    What is the output of the following codeblock?
    10
	9
	8
	7
	6
 */

public class Problem1 {
    public static void main(String[] args) {
        int y = 10;
		for (int x = 0; x < y; x++) {
			System.out.println(y);
			y = y - 1;
		}
    }
}
