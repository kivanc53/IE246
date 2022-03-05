package hws.hw1;

public class FindSecondMinPlus {
    public static void main(String[] args) {
        findSecondMin();
    }

    public static void findSecondMin() {
        int[] array = new int[]{1, 1, 2, 3, -4, -4, 0};
        array = selectionSortArray(array);

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] < array[i + 1] && array[i] != array[0]) {
                System.out.println(array[i]);
                return;
            }
        }
        System.out.println("No second minimum!");
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
