package lectures.l2;

public class Lecture2 {
    public static void main(String[] args) {

		/*
		 *  Primitive data types – which ones are used frequently
			Printing and escape characters and print
			For loops
			If statements
			Simple math operands, casting, and assignment operator = ++ iterator pre/post
			Logical operands (short-circuit), exclusive OR
			Divisibility modulus
        */

        int pageStart = 1; // integers -> short, int*, long
        int pageEnd;
        pageEnd = 70;
        String s = "IE246";

        System.out.print("I also suggest that you read the book, especially between pages " + pageStart + " and " + pageEnd + ".\n");

        // Can you print on the screen 170, using the defined integer variables only?
        System.out.println(pageStart + "" + pageEnd + "\t is how it looks when you use a string and plus sign.");
        System.out.println("I like " + s + " a lot.");

        double f = 2; // fractional numbers -> double*, float, etc.
        System.out.println(f);

        int a = 2, b = 3, c = 4;
        double db = 3;
        double dc = 4;
        System.out.println("Int output expected: " + c / a);
        System.out.println("Double output expected: " + dc / a);
        System.out.println("Int output expected: " + b / a); // int op -> output int
        System.out.println("Double output expected: " + db / a); // int&double op -> output double


        //Conventional loop
        for (int i = 0; i < 10; i++) {
            System.out.println("i is currently " + i);
        }


        // Some unconventional loops
        int j = -5;
        for (; j > 0; j = j - 1) {//the first time arount, initialization is done(if any) & condition is checked
            System.out.println("j is currently " + j);
            //iterator is kicked in (if any)
        }
        System.out.println("Outside the loop, j is currently " + j);


        int i;
        for (i = 0; i < 10; i = 2 * i + 1) {
            System.out.println("i is currently " + i);
        }
        System.out.println("Outside the loop, i is currently " + i);
        // !!Scope of variables!!

        // i++ -> i=i+1 (reflects i before incremented, if printed etc.)
        // i-- -> i=i-1
        // ++i -> i=i+1 (reflects i after incremented, if printed etc.)


        for (int k = 0; k < 10; k++) {
            System.out.println("k is currently " + k++);
        }
        for (int k = 0; k < 10; k++) {
            System.out.println("k is currently (post-increment) " + ++k);
        }

        // Further math operands
        int x, y;
        x = 5;
        y = 3;

        System.out.println("x+y=" + (x + y));
        System.out.println("x*y=" + (x * y));

        // cast into a double is usually needed for mathematical division
        // -- wrong way mathematically -- System.out.println("x/y="+(double)(x/y));
        System.out.println("x/y=" + ((double) x / y));

        // find remainder for a division
        System.out.println("Remainder for x/y is " + x % y);

        //Goal1: Print out the numbers between any two given boundaries, that are divisible by a given number.

        // ==
        // <
        // <=
        boolean e = true;
        if (!e) // ! is the negation
        {
            System.out.println("This statement is printed, if the condition holds.");
        }

        if (x < 2) {
            System.out.println("x is strictly less than 2.");
        } else if (x <= 4) {
            System.out.println("x is greater than or equal to 2 and less than or equal to 4.");
        } else if (x < 10) {
            System.out.println("x is strictly greater than 4 and strictly less than 10.");
        } else {
            System.out.println("x is greater than or equal to 10. Basically anything else that doesn't hold before.");
        }

        int lb = 120;
        int ub = 256;
        int divisor = 7;

        System.out.print("Numbers between " + lb + " and " + ub + " that are divisible by " + divisor + " are");
        for (int ii = lb; ii <= ub; ii++) {
            if (ii % divisor == 0) {
                System.out.print(" " + ii);
            }
        }
        System.out.println(".");


        //Goal2: Print out the factorial of a given integer.
        int given = 5;

        int fact = 1;
        for (i = 1; i <= given; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + given + " is " + fact);

        //here is an alternative approach
        fact = 1;
        for (i = given; i >= 1; i--) {
            fact = fact * i;
        }
        System.out.println("Factorial of " + given + " is " + fact);


        // Goal3: Print out the first given number of Fibonacci numbers.

        int firstGiven = 17;
        // Fibonacci sequence: 1, 1, 2, 3, 5, 8, 13, 21 ... f(n)=f(n-1)+f(n-2), f(1)=1, f(2)=1.


        int first = 1;
        int second = 1;
        int next;
        System.out.print(first + " " + second);
        for (i = 0; i < firstGiven - 2; i++) {
            next = first + second;
            System.out.print(" " + next);
            first = second;
            second = next;
        }
        System.out.println(); // a new line only

        // List the numbers between 1-100 (inclusive), that are divisible by 4,
        // and mark those that are also divisible by 3 with an asterisk in front?
        // 4 8 *12 16 20 28 32 *36...

        lb = 1;
        ub = 100;
        divisor = 4;
        int secondDivisor = 3;

        for (int k = lb; k <= ub; k++) {
            if (k % divisor == 0) {
                if (k % secondDivisor == 0) {
                    System.out.print("*");
                }
                System.out.print(k + " ");
            }
        }

        System.out.println();

        for (int k = lb; k <= ub; k++) {
            if (k % divisor == 0 && k % secondDivisor == 0) // && vs & OR || vs |
                System.out.print("*" + k + " ");

            if (k % divisor == 0 & !(k % secondDivisor == 0)) // place a ! in front of any boolean to negate
            {
                System.out.print(k + " ");
            }
        }
        System.out.println();

        // Goal4: Print out the exclusive OR for given two booleans without using the exclusive or operand ^.
        boolean boolA, boolB;

        System.out.println("OR TABLE");
        boolA = true;
        boolB = true;
        System.out.println("A: " + boolA + " \tB: " + boolB + "\t\tA OR B: " + (boolA | boolB));
        boolA = false;
        boolB = true;
        System.out.println("A: " + boolA + "\tB: " + boolB + "\t\tA OR B: " + (boolA | boolB));
        boolA = true;
        boolB = false;
        System.out.println("A: " + boolA + " \tB: " + boolB + "\tA OR B: " + (boolA | boolB));
        boolA = false;
        boolB = false;
        System.out.println("A: " + boolA + "\tB: " + boolB + "\tA OR B: " + (boolA | boolB));

        System.out.println();
        System.out.println("Exclusive OR TABLE");
        boolA = true;
        boolB = true;
        System.out.println("A: " + boolA + " \tB: " + boolB + "\t\tA XOR B: " + (boolA ^ boolB));
        boolA = false;
        boolB = true;
        System.out.println("A: " + boolA + "\tB: " + boolB + "\t\tA XOR B: " + (boolA ^ boolB));
        boolA = true;
        boolB = false;
        System.out.println("A: " + boolA + " \tB: " + boolB + "\tA XOR B: " + (boolA ^ boolB));
        boolA = false;
        boolB = false;
        System.out.println("A: " + boolA + "\tB: " + boolB + "\tA XOR B: " + (boolA ^ boolB));

        System.out.println();

        boolA = false;
        boolB = false;
        boolean answer = boolA | boolB;

        if (boolA && boolB) {
            answer = false;
        }

        System.out.println(answer);
    }
}
