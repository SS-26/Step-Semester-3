
package com.step.week4;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        int lowestPrice = prices[0];
        int maximumProfit = 0;

        for (int day = 1; day < prices.length; day++) {

            if (prices[day] < lowestPrice) {
                lowestPrice = prices[day];
            }

            int currentProfit = prices[day] - lowestPrice;

            if (currentProfit > maximumProfit) {
                maximumProfit = currentProfit;
            }
        }

        return maximumProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }
}
