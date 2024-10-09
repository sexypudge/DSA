package LeetCode.DynamicProgramming;

import java.util.Arrays;

public class Ex494TargetSum {
    static Integer[][] memo;
    static int total;
//    static Map<String, Integer> memo;

    /**
     * <a href="https://www.youtube.com/watch?v=g0npyaQtAQM&list=PLot-Xpze53lcvx_tjrr_m2lgD2NsRHlNO">...</a>
     * ================================================================================
     * Complexity Analysis for recursive solution
     * Time complexity: O(2^n). Size of recursion tree will be 2^n.
     * n refers to the size of nums array.
     * Space complexity: O(n). The depth of the recursion tree can go up to n.
     * ================================================================================
     * Complexity Analysis for Memoization Solution
     * Time complexity: O(t⋅n). The memo array of size O(t⋅n) has been filled just once.
     * Here, t refers to the sum of the nums array and n refers to the length of the nums array.
     * Space complexity: O(t⋅n). The depth of recursion tree can go up to n. The memo array contains t⋅n elements.
     */

    public static int findTargetSumWays(int[] nums, int target) {
        total = Arrays.stream(nums).sum();

        memo = new Integer[nums.length][2 * total + 1]; // we may have to store total possible value 'total' for [-5;5] including value '0'

//        memo = new HashMap<>();
        return calculate(nums, 0, 0, target);
    }

    public static int calculate(int[] nums, int index, int currentTotal, int target) {
        if (index == nums.length) {
            return currentTotal == target ? 1 : 0;
        }

        /*
         * 	why <currentTotal + total>?
         * 	actually we only need to store 'currentTotal' value to apply memoization solution: memo[index][currentTotal] (we can do this by using a hashMap)
         *  but using HashMap will be inefficient, so we decided to use a 2D Dimensional Array.
         *  But if <currentTotal> is negative, we can't store that negative index in 2D Dimensional Array (smt like memo[index][-1] is impossible)
         *  So we can plus <total> to always avoid negative index for <currentTotal> and still can represent <currentTotal> in case it's negative
         */

        if (memo[index][currentTotal + total] != null) {
            return memo[index][currentTotal + total];
        }

        // Generate a unique key for the memoization map
//        String key = index + "," + currentTotal;
//        if (memo.containsKey(key)) {
//            return memo.get(key);
//        }

        int add = calculate(nums, index + 1, currentTotal + nums[index], target);
        int subtract = calculate(nums, index + 1, currentTotal - nums[index], target);

        memo[index][currentTotal + total] = add + subtract;
//        memo.put(key, add + subtract);
//        return memo.get(key);n m
        return memo[index][currentTotal + total];
    }

    public static int findTargetSumWays2DArray(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();

        // If the absolute value of target is greater than the sum of the numbers, it's not possible
        if (Math.abs(target) > sum) return 0;

        // dp[i][j] represents the number of ways to get sum j with the first i elements
        // Shift index by `sum` to handle negative sums (i.e., dp[index][sum + shift])
        int offset = sum;  // Shift to handle negative indices
        int[][] dp = new int[nums.length + 1][2 * sum + 1]; // Array size is [n+1][2*sum+1]

        // Base case: 1 way to make sum 0 with 0 elements (dp[0][sum] because of the offset)
        dp[0][offset] = 1;

        // Fill the DP table-0
        for (int i = 0; i < nums.length; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (dp[i][j + offset] != 0) { // offset = sum:
                    dp[i + 1][j + nums[i] + offset] += dp[i][j + offset]; // Adding nums[i]
                    dp[i + 1][j - nums[i] + offset] += dp[i][j + offset]; // Subtracting nums[i]
                }
            }
        }

        // Return the number of ways to achieve the target sum
        return dp[nums.length][target + offset];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1};
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{1, 2};

        System.out.println(findTargetSumWays2DArray(arr2, 3));
//        System.out.println(findTargetSumWays(arr, 3));
//          System.out.println(findTargetSumWays(arr1, 1));
//        System.out.println(findTargetSumWays2DArray(arr, 3));
    }
}
