package LeetCode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex128LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 1;
        int longest = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] - 1 == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }

    public static int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            hash.add(num);
        }

        int longest = 0;
        for (int num : nums) {
            int count = 1;
            if (!hash.contains(num - 1)) {
                int currentNum = num; // start to check from num

                while (hash.contains(currentNum + 1)) {
                    currentNum++; // increase to check consecutive sequence, started from num
                    count++;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }


    public static int longestConsecutiveByMe(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        Integer[] temp = new Integer[nums[maxIndex] + 1];
        for (int num : nums) {
            temp[num] = num;
        }

        int longestConsecutiveSequence = 0;
        int count = 0;
        for (int i = 0; i < nums[maxIndex] + 1; i++) {
            if (temp[i] != null) {
                count++;
            } else {
                count = 0;
            }

            if (longestConsecutiveSequence < count) {
                longestConsecutiveSequence = count;
            }
        }
        return longestConsecutiveSequence;
    }

    public static int longestConsecutiveTest(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int currentNum = num;
                while (set.contains(currentNum + 1)) {
                    count++;
                    currentNum++;
                }

                longest = Math.max(count, longest);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive2(new int[]{100, 4, 200, 1, 3, 2})); // Output: 4
    }
}
