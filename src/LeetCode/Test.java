package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] chars = s.toCharArray();
        int total = 0;

        for (int i = 0; i < chars.length; i++) {
            int current = map.get(chars[i]);
            int next = (i < chars.length - 1) ? map.get(chars[i+1]) : 0;

            if (current < next) {
                total = total - current;
            } else {
                total = total + current;
            }
        }

        return total;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] rs = new int[2];
        for (int i = 0; i < nums.length; i++) {

            int v = nums[i];
            if (map.get(v) != null) {
                rs[0] = i;
                rs[1] = map.get(v);
                return rs;
            } else {
                map.put(target - v, i);
            }
        }

        return rs;
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }

            map.put(num, true);
        }

        return false;
    }


    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        for (char c : s1) {
//            if (map.containsKey(c)) {
//                map.computeIfPresent(c, (v, k) -> k + 1);
//            } else {
//                map.put(c, 1);
//            }
            map.compute(c, (k, v) -> v == null ? 1 : v + 1);
        }

        for (char c : t1) {
//            if (map.containsKey(c)) {
//                map.computeIfPresent(c, (v, k) -> (k - 1) == 0 ? null : k-1);
//            } else {
//                return false;
//            }
            if (!map.containsKey(c)) return false;
            map.compute(c, (k, v) -> (v == 1) ? null : v - 1);
        }

        return map.isEmpty();
    }
}
