package lectures.l6;

import java.util.ArrayList;

public class Lecture6 {
    public static void main(String[] args) {
        // Find the median of a set of given numbers and provide the sorted list.
        // java RunWeek6 3 4 15.5
        // Median is 4.0
        // Sorted numbers are 3.0 4.0 15.5
        // java RunWeek6 3 4 5 15
        // Median is 4.5
        // Sorted numbers are 3.0 4.0 5.0 15.0
        // java RunWeek6 3.3 4.5 6.6
        // Median is 4.5
        // Sorted numbers are 3.3 4.5 6.6
        int n = args.length;
        if(n<1)
        {
            System.out.println("Please input some values.");
        }
        else {

            Bundle[] values = convert(args);


            if(isOdd(n))
            {
                int whereToLook = (n+1)/2;
                double median = minimum(values, whereToLook);
                System.out.println("Median is "+median);
            }
            else
            {
                int whereToLookOne = n/2;
                int whereToLookTwo = whereToLookOne+1;
                double firstVal = minimum(values,whereToLookOne);
                double secondVal = minimum(values,whereToLookTwo);

                double median = average(firstVal,secondVal);
                System.out.println("Median is "+median);
            }
            printSorted(values);
        }

    }



    public static void printSorted(Bundle[] array) {
        System.out.print("Sorted numbers are ");

        // Suppose we would like to also store these values in a sorted way...
        // store them as [ 1.0 2.0 2.0 3.0 4.0 5.0 5.0 10.0 ]
        // I can store them in an array, because I know the overall length
        // but in general, if you didn't know the length, arraylist is a good alternative to array
        // Pros: flexible compared to array - size is dynamically changing
        // Cons: performance

        // Define an arraylist - use class types to store, Integer, Double, String, your types (Bundle) etc.
        // .add adds and increases the size
        // you cannot access using [] like arrays, you have to use .get() method
        // in arrays it was length, in arraylists, it is .size()
        // other options to pop values out

        // you can write enhanced for loops around arraylists just like arrays

        ArrayList<Double> list= new ArrayList<>();

        for(int i=0;i<array.length;i++)
        {
            double currentValue = minimum(array,i+1);
            System.out.print(currentValue+" ");
            // add currentValue to my arraylist
            list.add(currentValue);

        }
        System.out.println();
        System.out.println("The size of this list is "+list.size()+ " and third value is "+list.get(3));
        // Write a method that adds a new value at the beginning of an arraylist pushing the current values by one.
        // Ex: Suppose integer list myArraylist is [5 3 9] and I call method myAdd(myArralist,7),
        // the method should return list [7 5 3 9].
    }
    private static double average(double a, double b) {
        return (a+b)/2;
    }
    private static boolean isOdd(int n) {
        return n%2==1;
    }
    public static Bundle[] convert(String[] a)
    {
        Bundle[] answer = new Bundle[a.length];

        for(int i=0;i<a.length;i++)
        {
            double val = Double.parseDouble(a[i]);
            Bundle thisBundle = new Bundle();
            thisBundle.value = val;
            thisBundle.pin = false;
            answer[i]=thisBundle;

            /*thisBundle-> Bundle
             * answer -> Bundle array
             * answer[1] -> Bundle
             * thisBundle.pin -> boolean
             * answer[1].pin -> boolean
             */
        }
        return answer;
    }
    public static double minimum(Bundle[] data, int order)
    {
        // I assume all pins are false...
        data=detox(data);
        int minIndex=0;
        for(int count=0; count<order ; count++)
        {
            minIndex = LocationOfUnpinnedMin(data);
            // How would you access the pin for minIndex-th value?
            data[minIndex].pin = true;
        }
        // How would you access the value for minIndex-th value?
        return data[minIndex].value;
    }
    private static Bundle[] detox(Bundle[] data) {
        for(Bundle b:data)
            b.pin=false;
        return data;
    }
    private static int LocationOfUnpinnedMin(Bundle[] data) {
        double minValue = Integer.MAX_VALUE;
        int minIndex=0;
        for (int i=0;i<data.length;i++) // for(Bundle currentBundle : data)
        {
            Bundle currentBundle = data[i];
            if(currentBundle.value<minValue && ! currentBundle.pin) {
                minValue=currentBundle.value;
                minIndex = i;
            }
        }
        return minIndex;
    }
}
