package LeetCode.Array;

import java.util.*;

public class Ex49GroupAnagram {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] strArr = s.toCharArray();
            Arrays.sort(strArr);
            String key = new String(strArr); // dùng chuỗi đã sort làm key
            ans.computeIfAbsent(key, k -> new ArrayList<>())
                    .add(s);
        }

        return new ArrayList<>(ans.values());
    }

    public static List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            char[] chars = str.toCharArray();
            int[] count = new int[26];
            for (char c : chars) {
                count[c-'a']++; // count[c - 'a'] = count[c - 'a'] + 1
            }

            StringBuilder builder = new StringBuilder();
            for (int countIndex : count) {
                builder.append(countIndex).append("#");
            }

            map.computeIfAbsent(builder.toString(), k -> new ArrayList<>())
                    .add(str);

        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
//        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs = {"eat", "tea"};
        groupAnagrams1(strs);
    }
}

