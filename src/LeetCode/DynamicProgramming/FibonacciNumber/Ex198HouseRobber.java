package LeetCode.DynamicProgramming.FibonacciNumber;

public class Ex198HouseRobber {

    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] robList = new int[nums.length];
        robList[0] = nums[0];
        robList[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            robList[i] = nums[i] + (i < 3 ? robList[i - 2] : Math.max(robList[i - 3], robList[i - 2]));
        }

        return Math.max(robList[nums.length - 1], robList[nums.length - 2]);
    }

    public static int robSliding(int[] nums) {
        int prev = 0;
        int cur = 0;

        for (int num : nums) {
            int temp = cur;
            cur = Math.max(cur, prev + num);
            prev = temp;
        }

        return cur;
    }


    public static int robLeetCode(int[] nums) {
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }

    static Integer[] memo;

    public static int robRecursive(int[] nums) {
        memo = new Integer[nums.length];
        return rob(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int idx) {
        if (idx < 0) return 0;

        if (memo[idx] != null) return memo[idx];

        memo[idx] = Math.max(rob(nums, idx - 2) + nums[idx], rob(nums, idx - 1));

        return memo[idx];
    }

    /**
     * cách tính: Tổng số tiền mình kiếm được từ trước đó cho đến cái nhà đó (bao gồm cả nhà đã bỏ qua)
     * Time Complexity = O(2^N): vì mỗi hàm đều gọi lại hàm dfs 2 lần
     * Space Complexity= O(N): tính bằng độ sâu của recursive (call stack) = 5 lần gọi cho đến khi dfs(-1) => O(N)
     */
    private static int dfs(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

//        if (i == 0) {
//            return  nums[0];
//        }
//
//        if (i == 1) {
//            return  Math.max(nums[0], nums[1]);
//        }

        return Math.max(dfs(nums, i - 1), dfs(nums, i - 2) + nums[i]);
    }

    public static int cal(int[] nums) {
        return dfs(nums, nums.length - 1);
    }

    public static void main(String[] args) {
//        System.out.println(robRecursive(new int[]{114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240}));
        System.out.println(robSliding(new int[]{3, 2, 1, 3}));
        System.out.println(robSliding(new int[]{2, 1, 1, 2}));
        System.out.println(robLeetCode(new int[]{2, 1, 1, 2}));
//        System.out.println(cal(new int[]{1,2,3,1}));
    }


    public int robDP(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}
