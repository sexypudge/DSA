package LeetCode.DynamicProgramming;

public class Ex1130MinCostTreeFromLeafValues {

    static int[][] memo;

    public static int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        memo = new int[n][n];
        return dfs(arr, 0, n - 1);
    }

    public static int dfs(int[] arr, int start, int end) {

        if (start == end) {
            return 0;
        }

        if (memo[start][end] > 0) {
            return memo[start][end];
        }

        int result = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            int left = dfs(arr, start, i);
            int right = dfs(arr, i + 1, end);

            int maxLeft = 0;
            int maxRight = 0;

            for (int j = start; j <= i; j++) {
                maxLeft = Math.max(maxLeft, arr[j]);
            }

            for (int j = i + 1; j <= end; j++) {
                maxRight = Math.max(maxRight, arr[j]);
            }

            int sum = left + right + maxLeft * maxRight;
            result = Math.min(result, sum);
        }

        memo[start][end] = result;

        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{6, 2, 4, 7};
        System.out.println(mctFromLeafValues(arr));
    }
}
