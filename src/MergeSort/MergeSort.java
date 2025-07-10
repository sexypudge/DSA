package MergeSort;

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int midIndex = array.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));
        return merge(left, right);
    }

    /**
     * #divideAndConquer
     */
    private static int[] merge(int[] array1, int[] array2) {
        int size = array2.length + array1.length;
        int[] result = new int[size];
        int i = 0;
        int j = 0;
        int index = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                result[index] = array1[i];
                i++;
            } else {
                result[index] = array2[j];
                j++;
            }
            index++;
        }

        while (i < array1.length) {
            result[index] = array1[i];
            i++;
            index++;
        }

        while (j < array2.length) {
            result[index] = array2[j];
            j++;
            index++;
        }

        return result;
    }

    private static int[] mergeTest(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] result = new int[array1.length + array2.length];

        while (i < array1.length && j < array2.length) {

            if (array1[i] > array2[j]) {
                result[k] = array2[j];
                j++;
            } else {
                result[k] = array1[i];
                i++;
            }

            k++;
        }

        while (i < array1.length) {
            result[k] = array1[i];
            i++;
            k++;
        }

        while (j < array2.length) {
            result[k] = array1[j];
            j++;
            k++;
        }

        return result;
    }


    public static void main(String[] args) {
//        int[] array = {5, 4, 6, 2, 1, 3, 7, 8, 9};
        int[] array = {5, 3, 2, 1, 4 };
        int[] array1 = {1, 3, 7, 8};
        int[] array2 = {2, 4, 5, 6};

        System.out.println(Arrays.toString(mergeSort(array)));
        System.out.println(Arrays.toString(merge(array1, array2)));
    }
}
