package lectures.l5;

public class Lecture5 {
    public static void main(String[] args) {
        // Find the median of a set of given numbers.
        // java RunWeek5 3 4 15.5
        // Median is 4.0
        // java RunWeek5 3 4 5 15
        // Median is 4.5
        // java RunWeek5 3.3 4.5 6.6
        // Median is 4.5

        int n = args.length;
        if (n < 1) {
            System.out.println("Please input some values.");
        } else {

            double[] values = convert(args);

            if (n % 2 == 1) // n odd
            {
                int t = (n + 1) / 2;
                // find t-th minimum

                double median = tthminimum(values, t);
                System.out.println("Median is " + median);
            } else // n even
            {
                int t = n / 2;
                int s = t + 1;
                // find t-th and s-th minimums average
                double median = (tthminimum(values, t) + tthminimum(values, s)) / 2;
                System.out.println("Median is " + median);
            }
        }

        // How would you check if a string array (say args for now) includes a certain string?
        // Write a method that prints a message only "Yes this exists" or "No it doesn't".
        // Do not return anything.

        doesItExist(args, "2");


        // String[] a = args; // this is just a pointer as String[] is a class type
        // a[0]="";
        // this chanages args, why? Yes it does because they -> same location.

        // int y=9;
        // int z=y;
        // z=5;
        // what is the value of y now?
        // y is still 9, because it is a primitive type.
    }

    public static void doesItExist(String[] a, String b) {
        // this method only prints a message checking if a has b inside

        boolean didIprintAlready = false;
        for (String n : a) {
            if (n.equals(b)) {
                System.out.println("Yes " + b + " exists.");
                didIprintAlready = true;
                break;
            }
        }
        if (!didIprintAlready) {
            System.out.println("No " + b + " does not exist.");
        }

        // if I do the following, would that change args?
        // a[0]="5.5";
        // It would. So play it safe and do not update class types
        // that are input to your methods.


    }

    public static double[] convert(String[] a) {
        double[] answer = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            answer[i] = Double.parseDouble(a[i]);
        }
        return answer;
    }

    public static double tthminimum(double[] data, int order) {
        double minValue = Integer.MAX_VALUE;
        int minIndex = 0; // just temporarily set to some value to make Java happy

        boolean[] pin = new boolean[data.length]; // note: booleans are initialized as false by default in Java

        for (int count = 0; count < order; count++) {
            // we need to start with fresh minValue and minIndex

            // Just as an exercise, you can remove the following code block and
            // put it in a method that finds the next unpinned minimum from a data array
            // inputs: data, pin
            // return: minIndex
            // then you can keep pin[minIndex]=true; line after your method call.

            minValue = Integer.MAX_VALUE;
            minIndex = 0;
            for (int i = 0; i < data.length; i++) {
                if (data[i] < minValue && !pin[i]) {
                    minValue = data[i];
                    minIndex = i;
                }
            }
            pin[minIndex] = true;
        }
        //right here, how many pin's are true if order is 3? The answer is 3 :)
        return minValue;
    }
}
