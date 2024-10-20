package LeetCode.DynamicProgramming.StringMatchingDP;

public class Ex1143LongestCommonSubsequence {
    static int[] memo;

    public static int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()];
        int longest = 0;

        for (char c : text2.toCharArray()) {
            int curLen = 0;

            for (int i = 0; i < memo.length; i++) {
                if (curLen < memo[i]) {
                    //  This means that the current character c from text2 matches a subsequence
                    //  in text1 up to this point with a length of val.
                    curLen = curLen + 1; // memo[i]

                } else if (c == text1.charAt(i)) {
                    memo[i] = curLen + 1;
                    longest = Math.max(longest, memo[i]);
                }
            }
        }

        return longest;
    }

    public static int longestCommonSubsequence2(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();

        // Create a 2D array to store the lengths of longest common subsequences
        // for all sub-problems, initialized with zero
        int[][] dp = new int[length1 + 1][length2 + 1];

        // Build the dp array from the bottom up
        for (int i = 1; i <= length1; ++i) {
            for (int j = 1; j <= length2; ++j) {
                // If characters match, take diagonal value and add 1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // If characters do not match, take the maximum value from
                    // the left (dp[i][j-1]) or above (dp[i-1][j])
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // The bottom-right cell contains the length of the longest
        // common subsequence of text1 and text2
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence2("abcd", "dbca"));
//        System.out.println(longestCommonSubsequence("abcdef", "dbcaf"));
//        System.out.println(longestCommonSubsequence("abcd", "dcba"));
//        System.out.println(longestCommonSubsequence("a", "abc"));
    }
}
