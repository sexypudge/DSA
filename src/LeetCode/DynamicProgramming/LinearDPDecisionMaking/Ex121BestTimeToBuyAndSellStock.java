package LeetCode.DynamicProgramming.LinearDPDecisionMaking;

public class Ex121BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
		int maxProfit = 0;
        int dayMin = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[dayMin] > maxProfit ) {
                maxProfit = prices[i] - prices[dayMin];
            }

            if (prices[i] - prices[dayMin] < 0) {
                dayMin = i;
            }
        }

        return maxProfit;
    }

    public static int maxProfitSolution(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }


    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};

        int profit1 = maxProfit(prices1);
        System.out.println("Test case 1: Maximum profit: " + profit1); // prints "Maximum profit: 5"

        int[] prices2 = {7, 6, 5, 4, 3, 2, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("Test case 2: Maximum profit: " + profit2); // prints "Maximum profit: 0"

        int[] prices3 = {1, 2, 3, 4, 5, 6, 7};
        int profit3 = maxProfit(prices3);
        System.out.println("Test case 3: Maximum profit: " + profit3); // prints "Maximum profit: 6"

        int[] prices4 = {3, 2, 6, 5, 0, 3};
        int profit4 = maxProfit(prices4);
        System.out.println("Test case 4: Maximum profit: " + profit4); // prints "Maximum profit: 4"

        int[] prices5 = {2, 4, 1};
        int profit5 = maxProfit(prices5);
        System.out.println("Test case 5: Maximum profit: " + profit5); // prints "Maximum profit: 2"

        /*
            EXPECTED OUTPUT:
            ----------------
            Test case 1: Maximum profit: 5
            Test case 2: Maximum profit: 0
            Test case 3: Maximum profit: 6
            Test case 4: Maximum profit: 4
            Test case 5: Maximum profit: 2
        */

    }
}
