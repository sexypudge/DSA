package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Ex3 {
    public static Character firstNonRepeatingChar(String string) {
        Map<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (charCounts.get(c) == 1) {
                return c;
            }
        }

        return null;
    }


    public static Character firstNonRepeatingCharMySolution(String str) {
        char[] chars = str.toCharArray();
        if (chars.length == 1) {
            return chars[0];
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            Character c = chars[i];
            Integer value = map.get(c);

            if (value == null) {
                if (!map.isEmpty()) {
                    Character prevChar = chars[i -1];
                    if (map.get(prevChar) == 1) {
                        return prevChar;
                    }
                }
                map.put(c, 1);
            } else {
                map.put(c, value + 1);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));
        System.out.println(firstNonRepeatingChar("a"));
        System.out.println(firstNonRepeatingChar("!a"));
        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

    }
}
