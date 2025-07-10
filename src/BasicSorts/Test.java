package BasicSorts;

import Helper.Helper;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        doSelectionSort(new int[]{2, 3, 1, 9, 0, 8, 6, 4, 5});
//        doSelectionSort(new int[]{2, 3, 9, 4, 5, 7, 8, 6, 1});
        doInsertionSort(new int[]{4,2,3,1, 9, 7,5});
//            doIncreasingBubble(new int[]{3,1,2});
    }

    public static void doIncreasingBubble(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) { // duyệt ngược để bỏ qua những item đã sắp xếp ở cuối
            for (int j = 0; j < i; j++) { // bỏ qua những item đã sắp xếp ở cuối nên chỉ duyệt đến sát i
                if (array[j] > array[j + 1]) {
                    Helper.swap(array, j, j + 1);
                }
            }

        }

        System.out.println(Arrays.toString(array));
    }

    public static void doInsertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            while (i > 0
                    && array[i] < array[i-1]) {
                Helper.swap(array, i, i-1);
                i --;
            }
        }

        System.out.println(Arrays.toString(array));

    }

    public static void doSelectionSort(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            System.out.println("====i: " +i);
            int max = i;

            for (int j = 0; j <= i; j++) {
                System.out.println("j: " +j);
                if (array[j] > array[max]) {
                    max = j;
                }
            }
            Helper.swap(array, i, max);
        }

        System.out.println(Arrays.toString(array));
    }


}
