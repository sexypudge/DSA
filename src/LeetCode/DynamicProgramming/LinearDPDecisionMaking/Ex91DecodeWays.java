package LeetCode.DynamicProgramming.LinearDPDecisionMaking;

import java.util.Arrays;

public class Ex91DecodeWays {

    static int[] memo;

    public static int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo, -1);

        return memo(s, 0);
//        return recursiveDecode(s, 0);
    }

    private static int recursiveDecode(String s, int index) {
        // Log để quan sát từng nhánh đang đi
        System.out.println("dfs called with index = " + index);

        // Trường hợp base case: tới cuối chuỗi, tức là 1 cách decode hợp lệ cho cả chuỗi
        if (index == s.length()) {
            System.out.println(">> Reached end at index " + index + ", return 1");
            return 1;
        }

        // Nếu ký tự hiện tại là '0', không thể decode
        if (s.charAt(index) == '0') {
            System.out.println(">> Found '0' at index " + index + ", return 0");
            return 0;
        }

        // Decode single digit
        int count = recursiveDecode(s, index + 1);

        // Decode 2 chữ số nếu hợp lệ
        if (index + 1 < s.length()) {
            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                count += recursiveDecode(s, index + 2); // đệ quy duyệt tiep đoạn sau
            }
        }

        System.out.println("<< Returning from index = " + index + " with count = " + count);
        return count;
    }

    private static int memo(String s, int idx) {
        if (idx == s.length()) {
            return 1;
        }

        if (s.charAt(idx) == '0') {
            return 0;
        }

        if (memo[idx] != -1) return memo[idx];

        int num = memo(s, idx + 1);

        if (idx + 1 < s.length()) {
            int twoDigits = Integer.parseInt(s.substring(idx, idx + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                num += memo(s, idx + 2);
            }
        }

        return memo[idx] = num;
    }

    public static int numDecodingsBottomUp(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1; // base case: empty string

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < n) {
                    int twoDigit = Integer.parseInt(s.substring(i, i + 2));
                    if (twoDigit >= 10 && twoDigit <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
        }

        return dp[0];
    }



    public static void main(String[] args) {
        String[] testCases = {
                "12120",       // 3 ways
                "60",       // 0 ways
                "",         // 1 way (base case)
                "12",       // 2 ways
                "226",      // 3 ways
                "0",        // 0 ways
                "06",       // 0 ways
                "100",      // 0 ways
                "101",      // 1 way
                "110",      // 1 way
                "10",       // 1 way
                "1",        // 1 way
                "301",      // 0 ways
                "11106",    // 2 ways
                "111111",   // 13 ways
                "1010",     // 1 way
                "1201234",  // complex test - 3 ways
                "000"       // 0 ways
        };

        for (String str : testCases) {
            System.out.println("=>>> result: " + numDecodingsBottomUp(str));
            System.out.println("---------------------");
        }
    }
}
