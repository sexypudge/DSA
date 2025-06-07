package LeetCode.DynamicProgramming.LinearDPDecisionMaking;

import java.util.Arrays;

public class Ex322CoinChange {

    public int coinChangeLeetCode(int[] coins, int amount) {
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;
        for (int coin : coins) {
            for (int amt = coin; amt < amount + 1; amt++) {
                // if(coins[i] <= amt) {
                arr[amt] = Math.min(arr[amt], 1 + arr[amt - coin]);
                // }
            }
        }
        if (arr[amount] == amount + 1)
            return -1;
        return arr[amount];
    }

    public int coinChangeBottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];  // 0 included, ex: amount = 3, so length = 4 -because index from 0 to 3

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int fewestNoOfCoins = Integer.MAX_VALUE;

            for (int coin : coins) {
                int remaining = i - coin;

                if (remaining < 0 || dp[remaining] == -1 || dp[coin] == -1) {
                    continue;
                }

                if (remaining == 0) {
                    fewestNoOfCoins = 1;
                    break;
                }

                fewestNoOfCoins = Math.min(dp[remaining] + dp[coin], fewestNoOfCoins);
            }

            dp[i] = fewestNoOfCoins == Integer.MAX_VALUE ? -1 : fewestNoOfCoins;
        }

        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        Integer[] memo = new Integer[amount + 1]; // 0 included, ex: amount = 3, so length = 4 -because index from 0 to 3
        return change(coins, amount, memo);
    }

    public int change(int[] coins, int amount, Integer[] memo) {
        if (amount < 0) {
            return -1; // can't change coin using this path
        }

        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != null) {
            return memo[amount];
        }

        int fewestNoOfCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int fewestOfPath = change(coins, amount - coin, memo);
            if (fewestOfPath == -1) { // can't change coin using this path
                continue;
            }

            fewestNoOfCoins = Math.min(fewestNoOfCoins, fewestOfPath + 1); // find the fewest coins used by this path
        }

        memo[amount] = fewestNoOfCoins == Integer.MAX_VALUE ? -1 : fewestNoOfCoins;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 5};
        int[] arr1 = new int[]{1};

        Ex322CoinChange a = new Ex322CoinChange();
        System.out.println(a.coinChange(arr, 100));
        System.out.println(a.coinChangeBottomUp(arr1, 0));
    }

}
