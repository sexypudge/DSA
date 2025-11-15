package LeetCode.DynamicProgramming.UnboundedKnapsack;

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
        if (amount == 0) return 0;
        if (coins == null || coins.length == 0) return -1;

        // INF = amount + 1 (an upper bound: can't need more than amount coins of 1)\
        // INF = amount + 1 là một giá trị lớn hơn mọi số coin hợp lệ (nếu chỉ xài đồng 1, tối đa cần amount đồng),
        // dùng để khởi tạo mảng dp, tránh overflow khi cộng 1.
        int INF = amount + 1; // tránh lấy MAX INTEGER để tránh overflow khi + thêm 1
        int[] dp = new int[amount + 1]; // 0 included, ex: amount = 3, so length = 4 -because index from 0 to 3
        Arrays.fill(dp, INF);
        dp[0] = 0;

        // Build from 1 ... amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // min(dp[i], candidate) là rất quan trọng,
                    // vì ở mỗi i mình có thể tạo ra số tiền đó bằng nhiều cách khác nhau, và ta chỉ muốn ít xu nhất
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1); // candidate = dp[i - coin] + 1
                    // candidate là số xu ít nhất để tạo nên số số tiền "i-coin"
                    // + them 1 vì tính cả coin hiện tại sẽ là thêm 1 xu
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
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
        int[] arr = new int[]{5, 3, 1};
        int[] arr1 = new int[]{1};

        Ex322CoinChange a = new Ex322CoinChange();
        System.out.println(a.coinChange1(arr, 2));
//        System.out.println(a.coinChangeBottomUp(arr1, 0));
    }

    public static int coinChange1(int[] coins, int amount) {
        return recursive(coins, amount);
    }

    private static int recursive(int[] coins, int amount) {
        if (amount < 0) {
            return -1; // can't change coin using this path
        }

        if (amount == 0) {
            return 0;
        }

        int fewestNoOfCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            int fewestOfPath = recursive(coins, amount - coin);
            if (fewestOfPath == -1) { // can't change coin using this path
                continue;
            }
            // fewestOfPath + 1 to count number of coins in this path
            fewestNoOfCoins = Math.min(fewestNoOfCoins, fewestOfPath + 1); // find the fewest coins used by this path
        }

        return fewestNoOfCoins == Integer.MAX_VALUE ? -1 : fewestNoOfCoins;
    }
}
