package lectures.l3;

public class Hypotenuse {
    public static void main(String[] args) {

        String[] str = new String[]{"3", "4"};

        if (str.length == 2) {
            double edgeOne;
            double edgeTwo;

            // str (String) to be converted to double or int requires:
            // Integer.parseInt
            // Double.parseDouble

            edgeOne = Double.parseDouble(str[0]);
            edgeTwo = Double.parseDouble(str[1]);


            // Use Math.sqrt to find the square root of a number

            double hypotenuse = Math.sqrt(edgeOne * edgeOne + edgeTwo * edgeTwo);

            System.out.println(hypotenuse);

        } else {
            System.out.println("This code requires two inputs to run. Currently there are " + str.length + " inputs.");
        }

    }
}
