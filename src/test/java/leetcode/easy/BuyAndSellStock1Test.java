package leetcode.easy;

/**
 * Created by PV029500 on 10/6/2016.
 */
public class BuyAndSellStock1Test {

    public int maxProfit(int[] prices) {
        int profit = 0, minIndex = 0;
        int min = Integer.MAX_VALUE, max = -1;

        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
                max = -1;
            }
            if (prices[i] > max && i >= minIndex) {
                max = prices[i];
                profit = profit > max - min ? profit : max - min;
            }
        }

        return profit;
    }

}