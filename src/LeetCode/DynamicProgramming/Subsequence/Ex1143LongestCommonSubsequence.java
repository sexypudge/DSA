package LeetCode.DynamicProgramming.Subsequence;

public class Ex1143LongestCommonSubsequence {

    static Integer[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {

        memo = new Integer[text1.length()][text2.length()];

        return recursive(text1, text2, 0, 0);
    }

    private static int recursive(String text1,
                                 String text2,
                                 int idx1,
                                 int idx2) {
        if (memo[idx1][idx2] != null) {
            return memo[idx1][idx2];
        }

        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {

            memo[idx1][idx2] = recursive(text1, text2, idx1 + 1, idx2 + 1);
            return 1 + memo[idx1][idx2];
        }

        memo[idx1][idx2] = Math.max(
                recursive(text1, text2, idx1, idx2 + 1),
                recursive(text1, text2, idx1 + 1, idx2)
        );
        return memo[idx1][idx2];
    }


    public static int bottomUp(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m]; // độ dài LCS
    }
}
