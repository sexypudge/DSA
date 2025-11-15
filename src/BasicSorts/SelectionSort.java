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

            if (minIndex != i) {
                Helper.swap(array, i, minIndex);
            }
        }
    }

    public static void doSelectionSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int max = 0;

            for (int j = 0; j <= i; j++) {
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            Helper.swap(array, i, max);
        }

        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3, 9,0,8,7};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
