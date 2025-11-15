package LeetCode.DynamicProgramming.LinearDPDecisionMaking;

public class Ex152MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

//        for (int i = 0; i < nums.length; i++) {
//            int product = 1;
//            for (int j = i; j < nums.length; j++) {
//                product = nums[j] * product;
//                maxProduct = Math.max(maxProduct, product);
//            }
//        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int product = 1;
            for (int j = i; j >= 0; j--) {
                product = nums[j] * product;
                maxProduct = Math.max(maxProduct, product);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProductBottomUp(new int[]{2, 3, -8, -2, 4}));
//        System.out.println(maxProduct(new int[]{2, 3, -8, -2, 4}));
//        System.out.println(maxProductBottomUp(new int[]{-1, 2, 3, -10, 4}));
    }

    public static int maxProductBottomUp(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];

        int maxEnding = nums[0];
        int minEnding = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = maxEnding; // Dùng tempMax để tránh ghi đè
            int tempMin = minEnding; // Dùng tempMin để tránh ghi đè

            maxEnding = Math.max(nums[i], Math.max(nums[i] * tempMax, nums[i] * tempMin));
            minEnding = Math.min(nums[i], Math.min(nums[i] * tempMax, nums[i] * tempMin));

//            dp[i] = Math.max(maxEnding, dp[i - 1]);
            result = Math.max(maxEnding, result);
        }

//        return dp[nums.length - 1];
        return result;
    }


    public static int maxProductRecursive(int[] nums) {
        return recursive(nums, 0, 1, 1, Integer.MIN_VALUE);
    }

    private static int recursive(int[] nums,
                                 int idx,
                                 int maxEnding,
                                 int minEnding,
                                 int result) {
        if (idx == nums.length) return result;
        int num = nums[idx];
        System.out.println("--------idx = " + idx + "--------");
        System.out.println("num = " + num );

        int newMax = Math.max(num, Math.max(num * maxEnding, num * minEnding));
        int newMin = Math.min(num, Math.min(num * maxEnding, num * minEnding));
        System.out.println("newMax = " + newMax );
        System.out.println("newMin = " + newMin );

        result = Math.max(result, newMax);
        System.out.println("result = " + result );

        System.out.println("-----------------");
        return recursive(nums, idx + 1, newMax, newMin, result);
    }
}
