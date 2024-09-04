package Practicing;

import Helper.Helper;

import java.util.Arrays;

public class BasicSortPractice {

    public static void bubbleSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            for(int j = 0; j <= i; j ++) {
                if (array[j] > array[j+1]) {
                    Helper.swap(array, j, j+1);
                }
            }
        }
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i ++) {
            int min = i;

            for (int j = i + 1; j < array.length; j ++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            Helper.swap(array, i, min);
        }
    }



    public static void insertionSort(int[] array) {

    }

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
        selectionSort(array);
//        bubbleSort(array);
//        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
