package BasicSorts;

import Helper.Helper;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        doInsertionSort(new int[]{7,2,3,1,9,0,8,6,4,5});
        doInsertionSort(new int[]{4,2,3,1});
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
            int key = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > key) {
                array[j+1] = array[j];
                j --;
            }

            array[j+1] = key;
        }

        System.out.println(Arrays.toString(array));

    }

    public static void doSelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    min = j;
                }
            }
            Helper.swap(array, i, min);
        }

        System.out.println(Arrays.toString(array));

    }



}
