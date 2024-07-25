package BasicSorts;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] array) {
        // array.length - 1: we start from the 2nd item so, max only 5 times of comparison
        // Besides, if i = 5 => j = 6 and array[6] throws OutOfBoundException
//        for (int i = 0; i < array.length - 1; i++) {
//            for (int j = i + 1; j > 0; j--) {
//                if (array[j] < array[j-1]) {
//                    int temp = array[j];
//                    array[j] = array[j-1];
//                    array[j-1] = temp;
//                }
//            }
//        }
//        for (int i = 1; i < array.length; i++) {
//            int temp = array[i];
//            int j = i - 1;
//            while (j > -1 && temp < array[j]) {
//                array[j+1] = array[j];
//                array[j] = temp;
//                j--;
//            }
//        }

        for (int i = 1; i < array.length; i++) {

            while (i > 0 && array[i - 1] > array[i]) {
                int temp = array[i];
                array[i] = array[i - 1];
                array[i - 1] = temp;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
