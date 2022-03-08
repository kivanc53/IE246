package lectures.l3;

public class Lecture3 {
    public static void main(String[] args) {

        /*
         * Input methods:
         * 1. Use System.in.read() - drawback, "one shot" - not useful
         * 2. Use Scanner - user inputs manually into the terminal screen
         * 3. Use of arguments *** only cover this because it is the most useful
         *
         * Arguments in Java are in an ARRAY
         *
         */

        // array example
        // array is not a primitive data type - class type
        // array is a "vector" of primitive types or class types (objects)

        int[] myFirstArray = new int[4];
        myFirstArray[0] = 2;
        int[] mySecondArray = {4, 5, 6, 7};

        myFirstArray[1] = 12;
        mySecondArray[2] = 5;
        myFirstArray[3] = 7;
        myFirstArray[2] = -12;
        System.out.println("The size of mySecondArray is " + mySecondArray.length);

        for (int i = 0; i < myFirstArray.length; i++) {
            System.out.print(myFirstArray[i] + " ");
        }

        System.out.println();
        System.out.println("***");


        // Given an array of size 5, where each entry has a value of index^2, find the sum of all values and print out the array.
        // System.out.print("Array is [0,1,4,9,16] and the sum is 30.");

        int myNumber = 5;

        // define the array
        int[] array = new int[myNumber];

        // populate the values
        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }

        // print out the array
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        // print out the sum
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        System.out.println("The sum is " + sum);

        //String[] myFirstStringArray= {"IE","246"};

        String[] myFirstStringArray = new String[2];

        myFirstStringArray[0] = "IE";
        myFirstStringArray[1] = "246";

        // print out the string array
        for (int i = 0; i < myFirstStringArray.length; i++) {
            System.out.print(myFirstStringArray[i] + " ");
        }
        System.out.println();


        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
        System.out.println();

    }
}
