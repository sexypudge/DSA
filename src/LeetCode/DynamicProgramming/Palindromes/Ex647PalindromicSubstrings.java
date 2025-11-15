package LeetCode.DynamicProgramming.Palindromes;

public class Ex647PalindromicSubstrings {

    public static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static int countSubstringsBrutalForce(String s) {
        int ans = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) ans++;
            }
        }

        return ans;
    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] memo = new boolean[n][n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            memo[i][i] = true;
            ans++;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                memo[i][i + 1] = true;
                ans++;
            }
        }

        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                if (s.charAt(i) == s.charAt(i + len - 1)
                        && memo[i + 1][i + len - 2]) {
                    memo[i][i + len - 1] = true;
                    ans++;
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
//        System.out.println(countSubstrings("aaa"));
        System.out.println(isPalindrome("aaa", 0, 2));
    }

    public int countSubstring1s(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                if (isPalindrome(substring, 0, substring.length() - 1)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int palindromicSubstringsDPUsingLen(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int len = 1; len <= n; len++) { // length of substring
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j) && (len <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }

        return count;
    }
    public int countSubstringsDPFromN1(String s) {
        int res = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                    res++;
                }
            }
        }

        return res;
    }

    public static int PalindromicSubstringsDPDebug(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int len = 1; len <= n; len++) { // length of substring
            System.out.println("=== Length = " + len + " ===");
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && (len <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                    System.out.println("Palindrome found: \"" + s.substring(i, j + 1) + "\" at (" + i + "," + j + "), total count=" + count);
                } else {
                    System.out.println("Not palindrome: \"" + s.substring(i, j + 1) + "\" at (" + i + "," + j + ")");
                }
            }
            System.out.println();
        }
        // Example debug output for "ababa":
//        === Length = 1 ===
//        Palindrome found: "a" at (0,0), total count=1
//        Palindrome found: "b" at (1,1), total count=2
//        Palindrome found: "a" at (2,2), total count=3
//        Palindrome found: "b" at (3,3), total count=4
//        Palindrome found: "a" at (4,4), total count=5
//
//                === Length = 2 ===
//        Not palindrome: "ab" at (0,1)
//        Not palindrome: "ba" at (1,2)
//        Not palindrome: "ab" at (2,3)
//        Not palindrome: "ba" at (3,4)
//
//                === Length = 3 ===
//        Palindrome found: "aba" at (0,2), total count=6
//        Palindrome found: "bab" at (1,3), total count=7
//        Palindrome found: "aba" at (2,4), total count=8
//
//                === Length = 4 ===
//        Not palindrome: "abab" at (0,3)
//        Not palindrome: "baba" at (1,4)
//
//                === Length = 5 ===
//        Palindrome found: "ababa" at (0,4), total count=9
//
//        Total palindromic substrings: 9


        return count;
    }


    public int countSubstringsDPFromN1Debug(String s) {
        int res = 0, n = s.length();
        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                        (j - i <= 2 || dp[i + 1][j - 1])) {

                    dp[i][j] = true;
                    res++;

                    System.out.printf("✅ Palindrome found: [%d,%d] \"%s\" → res=%d\n",
                            i, j, s.substring(i, j + 1), res);
                } else {
                    System.out.printf("❌ Not palindrome: [%d,%d] \"%s\"\n",
                            i, j, s.substring(i, j + 1));
                }
            }
        }
        // Example debug output for "ababa":
//        ✅ Palindrome found: [4,4] "a" → res=1
//        ✅ Palindrome found: [3,3] "b" → res=2
//        ✅ Palindrome found: [3,4] "ba" ❌ (không palindrome)
//        ✅ Palindrome found: [2,2] "a" → res=3
//        ✅ Palindrome found: [2,3] "ab" ❌
//        ✅ Palindrome found: [2,4] "aba" → res=4
//        ✅ Palindrome found: [1,1] "b" → res=5
//        ✅ Palindrome found: [1,2] "ba" ❌
//        ✅ Palindrome found: [1,3] "bab" → res=6
//        ✅ Palindrome found: [1,4] "baba" ❌
//        ✅ Palindrome found: [0,0] "a" → res=7
//        ✅ Palindrome found: [0,1] "ab" ❌
//        ✅ Palindrome found: [0,2] "aba" → res=8
//        ✅ Palindrome found: [0,3] "abab" ❌
//        ✅ Palindrome found: [0,4] "ababa" → res=9
//
//        Total palindromic substrings = 9

        return res;
    }

    public static class LongestPalindromicSubstringExpand {
        public static void main(String[] args) {
            String s = "ababa";
            System.out.println("Longest Palindrome: " + longestPalindrome(s));
        }

        public static String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) return "";
            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);       // odd length
                int len2 = expandAroundCenter(s, i, i + 1);   // even length
                int len = Math.max(len1, len2);

                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private static int expandAroundCenter(String s, int left, int right) {
            System.out.println("\n--- New Center: left=" + left + ", right=" + right + " ---");
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                System.out.println("Match: s[" + left + "]=" + s.charAt(left)
                        + " , s[" + right + "]=" + s.charAt(right));
                left--;
                right++;
            }
            System.out.println("Stop at left=" + left + ", right=" + right);
            return right - left - 1;
        }
    // Debug log (chạy với "ababa")
//        --- New Center: left=0, right=0 ---
//        Match: s[0]=a , s[0]=a
//        Stop at left=-1, right=1
//
//                --- New Center: left=0, right=1 ---
//        Stop at left=0, right=1
//
//                --- New Center: left=1, right=1 ---
//        Match: s[1]=b , s[1]=b
//        Match: s[0]=a , s[2]=a
//        Stop at left=-1, right=3
//
//                --- New Center: left=2, right=2 ---
//        Match: s[2]=a , s[2]=a
//        Match: s[1]=b , s[3]=b
//        Match: s[0]=a , s[4]=a
//        Stop at left=-1, right=5
//
//                --- New Center: left=2, right=3 ---
//        Stop at left=2, right=3
//                ...

    }

}
