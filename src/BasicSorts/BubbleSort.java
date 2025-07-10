package BasicSorts;

import java.util.Arrays;

public class BubbleSort {
    public static void doIncreasingBubble(int[] array) { // compare
        for (int i = array.length - 1; i > 0; i--) {
            System.out.println("====i: " +i);
            for (int j = 0; j < i; j++) {
                System.out.println("j: " + j);
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
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

//            for (int j = point.length - 1; j > i; j--) {
//                if (point[j] > point[j - 1]) {
//                    int temp = point[j];
//                    point[j] = point[j - 1];
//                    point[j - 1] = temp;
//                }
//            }
        }
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3, 7};
        doIncreasingBubble(array);
        System.out.println(Arrays.toString(array));

//        int[] array1 = {4, 2, 6, 5, 1, 3};
//        doDecreasingBubble(array1);
//        System.out.println(Arrays.toString(array1));
    }
}
