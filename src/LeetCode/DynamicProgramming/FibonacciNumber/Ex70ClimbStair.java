package LeetCode.DynamicProgramming.FibonacciNumber;

public class Ex70ClimbStair {

    public static int climbStairs(int n) {
        return climb(n);
    }

    private static int climb(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        return climb(n - 1) + climb(n - 2);
    }

    /**
     * #DynamicProgramming #BottomUp with #Memo
     */
    public static int climbStairsBottomUp(int n) {
        // n+1 because need to store step index 0
        int[] waysList = new int[n + 1];

        // we start from step 0
        waysList[0] = waysList[1] = 1;

        for (int i = 2; i <= n; i++) {
            waysList[i] = waysList[i - 1] + waysList[i - 2];
        }

        return waysList[n];
    }

    static Integer[] memo;

    /**
     * #DynamicProgramming #topDown with #Memo
     */
    public static int climbStairsTopDown(int n) {
        memo = new Integer[n + 1]; // n + 1 because from index 0 to index n needs n+1 length
        return climbTopDown(n);
    }

    private static int climbTopDown(int n) {
        if (memo[n] != null) {
            return memo[n];
        }

        if (n == 1 || n == 2) {
            return n;
        }

        memo[n] = climbTopDown(n - 1) + climbTopDown(n - 2);
        return memo[n];
    }


    public static void main(String[] args) {
        System.out.println(climb(3));
        System.out.println(climbStairsBottomUp(3));
        System.out.println(climbStairsTopDown(3));
    }

}
