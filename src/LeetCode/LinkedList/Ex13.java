package LeetCode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Ex13 {

    public static int romanToIntSolution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i < s.length() - 1
                    && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                ans -= map.get(s.charAt(i));
            } else {
                ans += map.get(s.charAt(i));
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(romanToIntSolution("MCMXCIV"));
    }

    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        char[] chars = s.toCharArray();
        if (chars.length < 1 || chars.length > 15) {
            return 0;
        }
        int count = 0;
        char lastChar = 0;

        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == 'I') {
                count = count + 1;
            }

            if (chars[i] == 'V') {
                count += lastChar == 'I' ? (4 - 1) : 5;
            }

            if (chars[i] == 'X') {
                count += lastChar == 'I' ? (9 - 1) : 10;
            }

            if (chars[i] == 'L') {
                count += lastChar == 'X' ? (40 - 10) : 50;
            }

            if (chars[i] == 'C') {
                count += lastChar == 'X' ? (90 - 10) : 100;
            }

            if (chars[i] == 'D') {
                count += lastChar == 'C' ? (400 - 100) : 500;
            }

            if (chars[i] == 'M') {
                count += lastChar == 'C' ? (900 - 100) : 1000;
            }
            lastChar = chars[i];
        }

        return count;
    }
}
