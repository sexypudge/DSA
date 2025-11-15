package BasicSorts;

import java.util.Arrays;

import static Helper.Helper.swap;

public class BubbleSort {
    public static void doIncreasingBubble(int[] array) { // compare
        for (int i = array.length - 1; i > 0; i--) { // i ko cần = 0 vì j bắt đầu ở 0 rồi.
            for (int j = 0; j < i; j++) { // j ko thể = i vì sẽ gây Array Index out Of Bound Exception khi j = i = array.length - 1 => array[j + 1] quá range
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void doDecreasingBubble(int[] point) {
        for (int i = 0; i < point.length - 1; i++) {
             for (int j = point.length - 1; j > i; j--) {
                 if (point[j] > point[j - 1]) {
                    int temp = point[j];
                    point[j] = point[j - 1];
                     point[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 6, 5, 1, 3, 7, 0};
//        int[] arr = {7, 6, 5, 4, 3, 2, 1, 0};
        doDecreasingBubble(arr);
        System.out.println(Arrays.toString(arr));

        int n = arr.length;
//        int[] array1 = {4, 2, 6, 5, 1, 3};
//        doDecreasingBubble(array1);
//        System.out.println(Arrays.toString(array1));


        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                }
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // hoán đổi để đưa phần tử lớn dần về cuối
                    swap(arr, j, j + 1);
                }
            }
        }

    }
}
