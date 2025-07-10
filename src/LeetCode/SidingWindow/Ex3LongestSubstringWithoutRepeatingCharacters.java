package LeetCode.SidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Ex3LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int longest = 0;
        int[] freq = new int[128];
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (freq[c] > 0) {
                freq[s.charAt(left)]--;
                left++;
            }

            freq[c]++;
            int window = right - left + 1;
            longest = Math.max(longest, window);

        }

        return longest;
    }

    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, longest = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Nếu c đã xuất hiện và nằm trong cửa sổ hiện tại
            if (map.containsKey(c)
                    && map.get(c) >= left) {
                left = map.get(c) + 1; // nhảy thẳng tới sau vị trí cũ
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }


    public int lengthOfLongestSubstringBruteForce(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int longest = 1;

        for (int start = 0; start < s.length(); start++) {

            int[] freq = new int[128];
            for (int end = start; end < s.length(); end++) {
                int window = end - start + 1;
                freq[s.charAt(end)]++;

                if (freq[s.charAt(end)] == 1) {
                    longest = Math.max(longest, window);
                } else {
                    break;
                }
            }
        }

        return longest;
    }

    public int lengthOfLongestSubstringBruteForce1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int longest = 0;

        for (int start = 0; start < s.length(); start++) {
            int[] freq = new int[128]; // Dùng ASCII đầy đủ

            for (int end = start; end < s.length(); end++) {
                char c = s.charAt(end);
                if (freq[c] > 0) {
                    break; // Gặp ký tự lặp, thoát khỏi window này
                }
                freq[c]++;
                int window = end - start + 1;
                longest = Math.max(longest, window);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abaa");
    }

}
