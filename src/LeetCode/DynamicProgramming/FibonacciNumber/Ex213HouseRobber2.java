package LeetCode.DynamicProgramming.FibonacciNumber;

import java.util.Arrays;

public class Ex213HouseRobber2 {

    public static int robSliding(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    private static int robLinear(int[] nums,
                                 int start,
                                 int end) {
        int prev = 0, curr = 0;

        for (int i = start; i <= end; i++) {
            int temp = curr;
            curr = Math.max(curr, prev + nums[i]);
            prev = temp;
        }

        return curr;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 1, 2};
        System.out.println(robSliding(nums));
        System.out.println(robRecursive(nums));
        System.out.println(robBottomUp(nums));
        System.out.println(robBottomUp(new int[]{2,3,2})); // 3
        System.out.println(robBottomUp(new int[]{1,2,3,1})); // 4
        System.out.println(robBottomUp(new int[] {1, 3, 1, 3, 100})); // 103
    }

    public static int robRecursive(int[] nums) {

        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Case 1: rob houses from 0 to n - 2
        int rob1 = robRecur(Arrays.copyOfRange(nums, 0, n - 1), n - 2);

        // Case 2: rob houses from 1 to n - 1
        int rob2 = robRecur(Arrays.copyOfRange(nums, 1, n), n - 2);

        return Math.max(rob1, rob2);
    }

    private static int robRecur(int[] nums, int idx) {
        if (idx < 0) return 0;

        return Math.max(robRecur(nums, idx - 2) + nums[idx], robRecur(nums, idx - 1));
    }

    public static int robRecursiveOptimized(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        Integer[] memo1 = new Integer[n];
        Integer[] memo2 = new Integer[n];

        int rob1 = robRecurMemo(nums, 0, n - 2, memo1);
        int rob2 = robRecurMemo(nums, 1, n - 1, memo2);

        return Math.max(rob1, rob2);
    }

    private static int robRecurMemo(int[] nums,
                                    int start,
                                    int end,
                                    Integer[] memo) {
        if (end < start) return 0;
        if (memo[end] != null) return memo[end];

        int take = robRecurMemo(nums, start, end - 2, memo) + nums[end];
        int skip = robRecurMemo(nums, start, end - 1, memo);

        return memo[end] = Math.max(take, skip);
    }

    public static int robBottomUp(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        // đảm bảo có ít nhất 2 phần tử trở lên khi xét xuống dưới
        int rob1 = robBu(nums, 0, n - 2);
        int rob2 = robBu(nums, 1, n - 1);

        return Math.max(rob1, rob2);
    }

    private static int robBu(int[] nums,
                             int start,
                             int end) {
        int len = end - start + 1; // cần chứa phần tử có idx = 0
        if (len == 0) return 0;
        if (len == 1) return nums[start];

        int[] dp = new int[len];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[start + i] + dp[i - 2], dp[i - 1]);
        }

        return dp[len - 1];
    }
}
