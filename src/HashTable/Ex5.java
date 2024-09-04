package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Ex5 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(num, i);
        }

        return new int[]{};
    }

    public static int[] twoSumMySolution(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Boolean> map = new HashMap<>();
        map.put(target, true);

        for (int j = 0; j < nums.length - 1; j++) {
            for (int i = j + 1; i < nums.length; i++) {
                int total = nums[j] + nums[i];
                Boolean value = map.get(total);
                if (value != null) {
                    result[0] = j;
                    result[1] = i;
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

    }
}
