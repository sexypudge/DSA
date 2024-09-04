package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex2 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Boolean> map = new HashMap<>();
        for (Integer n : nums) {
            Boolean value = map.get(n);
            if (value == null) {
                map.put(n, true);
            } else {
                if (!duplicates.contains(n)) {
                    duplicates.add(n);
                }
            }
        }

        return duplicates;
    }



    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */
    }
}
