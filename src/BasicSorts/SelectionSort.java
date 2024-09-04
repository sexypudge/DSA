package BasicSorts;

import Helper.Helper;

import java.util.Arrays;

public class SelectionSort {
    /**
     *  Gen comment
     * @param array
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }

            Helper.swap(array, i, minIndex);
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
