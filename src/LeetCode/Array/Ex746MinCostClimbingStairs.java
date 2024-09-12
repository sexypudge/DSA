package LeetCode.Array;

public class Ex746MinCostClimbingStairs {
    /**
     * #DynamicProgramming #Topdown
     */
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private static int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    /**
     * #DynamicProgramming #topDown with #Memo
     */
    static Integer[] memo;

    public static int minCostClimbingStairsTopdownMemo(int[] cost) {
        int n = cost.length;
        memo = new Integer[n]; // O(n) space complexity: each cost needs to store its min cost
        return Math.min(minCostTopdownMemo(cost, n - 1), minCostTopdownMemo(cost, n - 2));
    }

    private static int minCostTopdownMemo(int[] cost, int n) {

        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 0 || n == 1) {
            return cost[n];
        }

        memo[n] = cost[n] + Math.min(minCostTopdownMemo(cost, n - 1), minCostTopdownMemo(cost, n - 2));
        return memo[n];
    }

    /**
     * #DynamicProgramming #BottomUp with #Memo
     */
    public static int minCostClimbingStairsBottomUpMemo(int[] cost) {
        int n = cost.length;
        int[] costList = new int[n + 1];
        costList[0] = cost[0];
        costList[1] = cost[1];

        for (int i = 2; i < n; i++) {
            costList[i] = cost[i] + Math.min(costList[i - 1], costList[i - 2]);
        }

        return Math.min(costList[n - 1], costList[n - 2]);
    }

    // #DynamicProgramming Bottom up Fine Tuning computation - O(n) time, O(1) space
    public static int minCostClimbingStairsBottomUpFineTuning(int[] cost) {
        int n = cost.length;

        int first = cost[0];
        int second = cost[1];

        if (n <= 2) return Math.min(first, second);

        for (int i = 2; i < n; i++) {
            int curr = cost[i] + Math.min(first, second);
            first = second;
            second = curr;
        }

        return Math.min(first, second);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{10, 15, 20};
        int[] arr1 = new int[]{1, 100, 1, 1, 1};

        System.out.println(minCostClimbingStairs(arr1));
        System.out.println(minCostClimbingStairsTopdownMemo(arr1));
        System.out.println(minCostClimbingStairsBottomUpMemo(arr1));
        System.out.println(minCostClimbingStairsBottomUpFineTuning(arr1));
    }
}
