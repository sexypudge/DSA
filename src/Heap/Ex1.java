package Heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ex1 {

    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }

    public static int findKthSmallestMySolution(int[] nums, int k) {
        Heap heap = new Heap();
//        PriorityQueue<Integer> p = new PriorityQueue<>((a, b) -> b - a);

        for (Integer i : nums) {
//            p.add(i);
            heap.insert(i);
        }

        if (nums.length < k || k <= 0) {
            return 0;
        }

        k = nums.length - k; // k smallest number

        for (int i = 1; i <= k; i ++) {
//            if (i == k) {
//                return heap.remove();
//            }
            heap.remove();
//            p.remove();
        }

        return  heap.remove();
//             return  p.remove();
    }

    public static void main(String[] args) {
        // Test case 1
//        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int[] nums1 = {20, 10, 4, 3, 7, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallestMySolution(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
        System.out.println();


        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1:
            Expected output: 7
            Actual output: 7

            Test case 2:
            Expected output: 2
            Actual output: 2

            Test case 3:
            Expected output: 7
            Actual output: 7

        */
    }
}
