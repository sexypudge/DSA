package DynamicProgramming;

import java.util.Arrays;

public class FindMaxMinWithDynamicProgramming {
    public static int[] findMinBottomUp(int[] ways) {
        int[] result = new int[2];
		Integer min = null;
		Integer max = null;

        for (int v : ways) {

        }

        result[0] = max == null ? 0 : max;
        result[1] = min == null ? 0 : min;

        return result;
    }


    public static void main(String[] args) {

    }
}
