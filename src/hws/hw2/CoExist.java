package hws.hw2;


/*
Write a method named coExist that takes two string arrays,
and returns a string array that contains the common elements that appear in both of the input string arrays.
 */
public class CoExist {
    public static void main(String[] args) {
        String[] array = new String[]{"ali", "veli", "cefa", "memo"};
        String[] array2 = new String[]{"ali", "velii", "cefai", "ali"};

        System.out.println(java.util.Arrays.toString(coExist(array, array2)));

    }

    public static String[] coExist(String[] array, String[] array2) {

        String[] returnArray = new String[Math.min(array.length, array2.length)];

        int count = 0;
        for (String str : array) {
            boolean flag = false;
            for (String str2 : array2) {
                if (str.equals(str2) && !flag) {
                    returnArray[count] = str;
                    flag = true;
                    count++;
                }
            }
        }
        return returnArray;
    }
}
