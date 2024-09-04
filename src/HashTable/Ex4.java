package HashTable;

import java.util.*;

public class Ex4 {

    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> mapListString = new HashMap<>();

        for (String str : strings) {
            Map<Character, Boolean> map = new HashMap<>();
            char[] chars = str.toCharArray();
            for (Character c : chars) {
                map.put(c, true);
            }

            Set<String> setKeys = mapListString.keySet();
            String contained = "";
            for (String k : setKeys) {
                boolean isMatched = true;
                char[] keyChars = k.toCharArray();
                for (Character c : keyChars) {
                    Boolean value = map.get(c);
                   if (value == null) {
                       isMatched = false;
                       break;
                   }
                }

                if (isMatched) {
                    contained = k;
                    break;
                }
            }

            if (contained.isEmpty()) {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                mapListString.put(str, anagrams);
            } else {
                List<String> anagrams = mapListString.get(contained);
                anagrams.add(str);
            }
        }

        return new ArrayList<>(mapListString.values());
    }


    public static void main(String[] args) {
        System.out.println("-2nd set:");
        System.out.println(groupAnagrams(new String[]{}));

        System.out.println("\n-1st set:");
        System.out.println(groupAnagrams(new String[]{""}));

        System.out.println("\n0th set:");
        System.out.println(groupAnagrams(new String[]{"eat"}));

        System.out.println("\n1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */

    }
}
