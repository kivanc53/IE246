package hws.hw1;

public class FindSecondMin {
    public static void main(String[] args) {
        findSecondMin();
    }

    public static void findSecondMin() {
        int[] array = new int[]{-1, 1, 2, 3, 4};
        array = selectionSortArray(array);
        System.out.println(array[1]);
    }

    public static int[] selectionSortArray(int[] array) {
        int min, p;
        for (int k = 0; k < array.length; k++) {
            min = array[k];
            p = k;
            for (int i = k; i < array.length; i++)
                if (array[i] < min) {
                    min = array[i];
                    p = i;
                }
            array[p] = array[k];
            array[k] = min;
        }
        return array;
    }
}
