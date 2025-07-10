package LeetCode.SidingWindow;

public class Ex424LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int maxLen = 0;

        for (int start = 0; start < s.length(); start++) {
            int[] freq = new int[26];
            int maxFreq = 0; // maxFrequency là cái mình giữ lại

            for (int end = start; end < s.length(); end++) {
                char ch = s.charAt(end);
                int idx = ch - 'A';

                freq[idx]++;
                maxFreq = Math.max(maxFreq, freq[idx]);

                int windowSize = end - start + 1; // độ dài của chuỗi hiện tại
                int needReplace = windowSize - maxFreq; // needReplace chính là số ký tự cần thay thế để tất cả ký tự trong window đều giống nhau

                // ✅ LOG DEBUG
                System.out.println("Checking substring: \"" + s.substring(start, end + 1) + "\"");
                System.out.println("  Freq[" + ch + "] = " + freq[idx]);
                System.out.println("  maxFreq = " + maxFreq);
                System.out.println("  windowSize = " + windowSize);
                System.out.println("  needReplace = " + needReplace);
                System.out.println("  IsValid = " + (needReplace <= k));

                if (needReplace <= k) {
                    maxLen = Math.max(maxLen, windowSize);
                    System.out.println("  Comparing maxLen = " + maxLen);
                }
                System.out.println("---------------------------------");
            }
        }

        return maxLen;
    }

    public static int characterReplacementSlidingWindow(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowSize = right - left + 1;
            int replaceNeeded = windowSize - maxFreq;
            System.out.println("Current left: " + left);
            System.out.println("Window: " + s.substring(left, right + 1));
            System.out.println("MaxFreq: " + maxFreq + ", ReplaceNeeded: " + replaceNeeded);

            if (replaceNeeded > k) {
                System.out.println("decreasing left: " + s.charAt(left));
                freq[s.charAt(left) - 'A']--;
                left++;
            } else {
                result = Math.max(result, windowSize);
                System.out.println("Current Result: " + result);
            }
            System.out.println("================");
        }

        return result;
    }

    public static int characterReplacementSlidingWindow2(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int left = 0;
        int result = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            System.out.println("Current left: " + left);
            System.out.println("Current right: " + right);
            // cập nhật maxFreq dựa trên freq mới
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);


            int windowSize = right - left + 1;
            int replaceNeeded = windowSize - maxFreq;

            System.out.println("Window: " + s.substring(left, right + 1));
            System.out.println("MaxFreq: " + maxFreq + ", ReplaceNeeded: " + replaceNeeded);

            // nếu số kí tự cần thay > k → co cửa sổ
            while (replaceNeeded > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                System.out.println("Updating Left: " + left);

                windowSize = right - left + 1;
                replaceNeeded = windowSize - maxFreq;
            }

            result = Math.max(result, right - left + 1);
            System.out.println("Current Result: " + result);
            System.out.println("================");
        }

        return result;
    }

    public static int characterReplacementBruteForce(String s, int k) {
        int maxLen = 0;

        for (int start = 0; start < s.length(); start ++) {
            int maxFreq = 0;// maxFreq to keep max Frequency of a character of previous window
            int[] freq = new int[26];

            for (int end = start; end < s.length(); end++) {
                char ch = s.charAt(end);
                freq[ch - 'A']++;

                int windowSize = start - end + 1;
                maxFreq = Math.max(maxFreq, freq[ch - 'A']);
                int needReplace = windowSize - maxFreq;

                if (needReplace <= k) {
                    maxLen = Math.max(maxLen, windowSize);
                }

            }

        }
        return maxLen;
    }

    public static int characterReplacementSlideWindow3(String s, int k) {
        int result = 0;
        int left = 0;
        int[] freq = new int[26];
        int maxFreq = 0;// maxFreq to keep max Frequency of a character of previous window

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            int windowSize = right - left + 1;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            int needReplace = windowSize - maxFreq;

            if (needReplace <= k) {
                result = Math.max(windowSize, result);
            } else {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

        }

        return result;
    }

    public static void main(String[] args) {
//        System.out.println(characterReplacement("AABABBA", 1));
//        System.out.println(characterReplacement("AABBA", 2));
//        System.out.println(characterReplacement("AABABBAAA", 2));
//        System.out.println(characterReplacementSlidingWindow("ABBABB", 1));
        System.out.println(characterReplacementSlidingWindow2("ABCDEFFFFF", 1));
    }
}
