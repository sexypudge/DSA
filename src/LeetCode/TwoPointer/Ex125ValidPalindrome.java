package LeetCode.TwoPointer;

import java.util.*;

public class Ex125ValidPalindrome {
    public boolean isValidPalindrome(String str) {
        Set<Character> alphanumSet = new HashSet<>();
        for (char c = 'a'; c <= 'z'; c++) alphanumSet.add(c);
        for (char c = '0'; c <= '9'; c++) alphanumSet.add(c);

        char[] chars = str.toLowerCase().toCharArray();

        Stack<Character> stack = new Stack<>();
        List<Character> filteredChars = new ArrayList<>();

        for (char c : chars) {
            if (alphanumSet.contains(c)) {
                stack.push(c);
                filteredChars.add(c);
            }
        }

        for (char c : filteredChars) {
            if (stack.pop() != c) return false;
        }

        return true;
    }

    public boolean isValidPalindromeTest(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char charAtLeft = str.charAt(left);
            char charAtRight = str.charAt(right);

            if (!Character.isLetterOrDigit(charAtLeft)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(charAtRight)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(charAtLeft) != Character.toLowerCase(charAtRight)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
