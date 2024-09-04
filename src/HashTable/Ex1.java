package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Ex1 {
    public static boolean itemInCommon(int[] array1, int[] array2) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (Integer a1 : array1) {
            map.put(a1, true);
        }

        for (Integer a2 : array2) {
            Boolean value = map.get(a2);
            if (value != null) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 6};

        System.out.println(itemInCommon(array1, array2));
    }
}
