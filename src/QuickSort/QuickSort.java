package QuickSort;

import java.util.Arrays;

import static Helper.Helper.*;

public class QuickSort {
    private static int pivot(int[] array, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for (int i = pivotIndex + 1; i <= endIndex; i++) {
            if (array[i] < array[pivotIndex]) {
                swapIndex++;
                swap(array, swapIndex, i);
            }
        }

        swap(array, pivotIndex, swapIndex);
        return swapIndex;
    }

    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(array, left, right);
            sort(array, left, pivotIndex - 1);
            sort(array, pivotIndex + 1, right);
        }
    }

    public static int[] quickSort(int[] array) {
        sort(array, 0, array.length - 1);
        return array;
    }


    public static void main(String[] args) {
        int[] array = {4, 6, 1, 8, 3, 2, 5, 7};
        int[] array2 = {3, 4, 6, 7, 5};
//        System.out.println(pivot(array, 0, 6));
//        System.out.println(pivot(array, 1, 5));
//        System.out.println(Arrays.toString(quickSort(array)));
        System.out.println(Arrays.toString(quickSort(array2)));
    }
}
