package BasicSorts;

import Helper.Helper;

import java.util.Arrays;

public class BasicSortPractice {

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    Helper.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    Helper.swap(array, j, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
//        selectionSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
