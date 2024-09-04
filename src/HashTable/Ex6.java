package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Ex6 {

    public static int[] subarraySum(int[] nums, int target) {

        // Bản chất của cách giải bài này là: tính tổng và loại bỏ phần tử thừa ở đầu
        // Create a HashMap to store cumulative sum and index
        // Lưu tổng của nums từ i = 0 đến i hiện tại và index i hiện tại
        Map<Integer, Integer> sumIndex = new HashMap<>();
        // Initialize the HashMap with 0 sum and index -1
        sumIndex.put(0, -1); // giải quyết trường hợp số đầu tiên đã đúng là số target cần tìm
        // Initialize the current sum to 0
        int currentSum = 0;

        // Iterate through the input array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the cumulative sum
            currentSum += nums[i];
            // Check if the required subarray sum exists
            // nếu containsKey = true tức là đã xuất hiện đủ các con số trước đó cộng vào bằng số target
            if (sumIndex.containsKey(currentSum - target)) {
                // Return the start and end indices of the subarray
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            // Store the current sum and its index in the HashMap
            sumIndex.put(currentSum, i);
        }

        // Return an empty array if no subarray is found
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");

        int[] num5 = {9};
        int target5 = 9;
        int[] result5 = subarraySum(num5, target5);
        System.out.println("[" + result5[0] + ", " + result5[1] + "]");

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */

    }

}
