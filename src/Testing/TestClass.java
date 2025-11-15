package Testing;

import Helper.Helper;

import java.util.*;

public class TestClass {


    public static void main(String[] args) {
        testForLoop(new int[]{1, 2, 3, 4});
    }

    public static void testForLoop(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            System.out.println("==== i: " + i);

            for (int j = i; j < nums.length; j++) {
                System.out.println(" -- j: " + j);
            }
            System.out.println("--------------------");
        }
    }

    public static int numDecodingsBottomUp(String s) {
        int n = s.length();
        int[] ways = new int[s.length() + 1];

        ways[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ways[i] = 0;
            } else {
                ways[i] = ways[i + 1];
                if (i + 1 < n) {
                    int twoDigits = Integer.parseInt(s.substring(i, i + 2));
                    if (twoDigits >= 10 && twoDigits <= 26) {
                        ways[i] += ways[i + 2];
                    }
                }
            }
        }

        return ways[0];
    }

    public int minCostClimbingStairs(int[] cost) {
        return minCostRecursive(cost, 0, 0);
    }

    private static int minCostRecursive(int[] cost, int idx, int total) {
        if (idx >= cost.length) {
            return 0;
        }

        int currentCost = minCostRecursive(cost, idx + 1, total);
        int nextCost = minCostRecursive(cost, idx + 2, total);
        total = cost[idx] + Math.min(currentCost, nextCost);
        return total;
    }



}
