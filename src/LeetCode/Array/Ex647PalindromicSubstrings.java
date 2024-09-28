package LeetCode.Array;

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
}
