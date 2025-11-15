package LeetCode.DynamicProgramming.Subsequence;

import java.util.Arrays;

public class Ex300LongestIncreasingSubsequence {
    // lời gọi đệ quy phụ thuộc cả prevIdx và currIdx
    // Nghĩa là với cùng một currIdx nhưng khác prevIdx, kết quả có thể khác nhau -> cần DP-2D
    static Integer[][] memo; //

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // prevIdx có thể = -1 → dịch sang +1 để index không bị âm -> n+1 cho D2
        memo = new Integer[n][n + 1];
        return recursive(nums, -1, 0);
    }

    private static int recursive(int[] nums, int prevIdx, int currIdx) {
        if (currIdx == nums.length) {
            return 0;
        }

        if (memo[currIdx][prevIdx + 1] != null) {
            return memo[currIdx][prevIdx + 1];
        }

        // Option 1: bỏ qua nums[currIdx]
        int notTake = recursive(nums, prevIdx, currIdx + 1);

        // Option 2: chọn nums[currIdx] (nếu thỏa)
        int take = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            take = 1 + recursive(nums, currIdx, currIdx + 1);
        }

        return memo[currIdx][prevIdx + 1] = Math.max(take, notTake);
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        // Tính dp bottom-up
        for (int i = 1; i < n; i++) { //Ta đã khởi tạo dp[i] = 1 cho mọi i, nên i = 0 đã đúng sẵn
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }


//    dry run LIS bottom-up (O(N²)) cho nums = [9, 1, 4, 2, 3] đây ạ.
//
//    Quy ước: dp[i] = độ dài LIS kết thúc tại i. Khởi tạo dp = [1,1,1,1,1], maxLen = 1.
//    Điều kiện tăng: nums[j] < nums[i] với mọi j < i.
//
//            i = 0, nums[0] = 9
//
//    Không có j < 0.
//
//    dp = [1,1,1,1,1], maxLen = 1.
//
//    i = 1, nums[1] = 1
//
//    j=0: 9 < 1 ❌ ⇒ dp[1] giữ 1.
//
//    Sau i=1: dp = [1,1,1,1,1], maxLen = 1.
//
//    i = 2, nums[2] = 4
//
//    j=0: 9 < 4 ❌
//
//    j=1: 1 < 4 ✅ ⇒ dp[2] = max(1, dp[1]+1=2) = 2
//
//    Sau i=2: dp = [1,1,2,1,1], maxLen = 2.
//
//    i = 3, nums[3] = 2
//
//    j=0: 9 < 2 ❌
//
//    j=1: 1 < 2 ✅ ⇒ dp[3] = max(1, dp[1]+1=2) = 2
//
//    j=2: 4 < 2 ❌
//
//    Sau i=3: dp = [1,1,2,2,1], maxLen = 2.
//
//    i = 4, nums[4] = 3
//
//    j=0: 9 < 3 ❌
//
//    j=1: 1 < 3 ✅ ⇒ dp[4] = max(1, dp[1]+1=2) = 2
//
//    j=2: 4 < 3 ❌
//
//    j=3: 2 < 3 ✅ ⇒ dp[4] = max(2, dp[3]+1=3) = 3
//
//    Sau i=4: dp = [1,1,2,2,3], maxLen = 3.

    public static void main(String[] args) {
        int[] nums = {9, 1, 4, 2, 3};
        System.out.println(longestIncreasingSubsequence(nums)); // ✅ output = 3
    }

}
