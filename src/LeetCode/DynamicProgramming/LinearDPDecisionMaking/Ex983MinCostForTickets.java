package LeetCode.DynamicProgramming.LinearDPDecisionMaking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Ex983MinCostForTickets {

    private final Set<Integer> dayNeedToBuy = new HashSet<>();
    private static Integer[] memo;

    public int mincostTicketsBottomUp(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        Arrays.fill(dp, 0);

        int i = 0;
        for (int day = 1; day <= lastDay; day++) {
            // If we don't need to travel on this day, the cost won't change.
            if (day < days[i]) { // If the current day is less than days[i],
                // the cost for dp[day] would be the same as dp[day - 1]
                // as we don't need to travel on this day.
                dp[day] = dp[day - 1];
            } else {
                // Buy a pass on this day, and move on to the next travel day.
                i++;
                // Store the cost with the minimum of the three options.
                dp[day] = Math.min(dp[day - 1] + costs[0],
                        Math.min(dp[Math.max(0, day - 7)] + costs[1],
                                dp[Math.max(0, day - 30)] + costs[2]));
            }
        }

        return dp[lastDay];
    }

    public int mincostTickets(int[] days, int[] costs) {
        for (int day : days) {
            dayNeedToBuy.add(day);
        }
        memo = new Integer[days[days.length - 1] + 1]; // days are an array to store number of days to travel, we need to store until last day
        return min(days, 0, costs);
    }

    public int min(int[] days, int currentDay, int[] costs) {

        if (currentDay > days[days.length - 1]) {
            return 0;
        }

        if (memo[currentDay] != null) {
            return memo[currentDay];
        }

        if (!dayNeedToBuy.contains(currentDay)) {
            return min(days, currentDay + 1, costs);
        }

        int oneDayOpt = costs[0] + min(days, currentDay + 1, costs);
        int sevenDayOpt = costs[1] + min(days, currentDay + 7, costs);
        int thirstyDayOpt = costs[2] + min(days, currentDay + 30, costs);

        memo[currentDay] = Math.min(oneDayOpt, Math.min(sevenDayOpt, thirstyDayOpt));
        return memo[currentDay];
    }

    public static void main(String[] args) {
        int[] days = new int[]{1, 4, 6, 7, 8, 20};
        int[] days1 = new int[]{1, 3, 7};
        int[] costs = new int[]{2, 7, 15};
        int[] costs1 = new int[]{1, 4, 20};

        Ex983MinCostForTickets a = new Ex983MinCostForTickets();
//        System.out.println(a.mincostTickets(days, costs));
//        System.out.println(a.mincostTickets(days1, costs1));
        System.out.println(a.mincostTicketsBottomUp(days, costs));
    }
}
