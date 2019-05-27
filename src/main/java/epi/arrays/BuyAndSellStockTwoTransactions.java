package main.java.epi.arrays;

/**
 * Created by PV029500 on 1/12/2017.
 */

/**
 * Iterate through the array once from 0 to n - 1
 * store highest profit for each 0..i in an array
 * iterate again from n - 1 to 0
 * compare current profit from n - 1 .. i + array[i - 1] against max profit so far
 */
public class BuyAndSellStockTwoTransactions {

    public int maxProfit(int[] prices) {
        int[] forward = new int[prices.length];
        int min = Integer.MAX_VALUE, maxProfit = 0, max = Integer.MIN_VALUE;

        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);
            forward[i] = maxProfit;
        }

        for(int i = prices.length - 1; i >= 0; i--) {
            max = Math.max(max, prices[i]);
            maxProfit = Math.max(maxProfit, max - prices[i] + forward[i]);
        }

        return maxProfit;
    }

    public int maxProfitConstantSpace(int[] prices) {
        // 0...i..j..k
        //let's say i - 0 + k - j are the two transactions that give max profit
        //sell1 will always have max profit for 1 transaction so far
        // because sell1 = max(sell1, buy1 (-0 above) + prices[i])
        // total profit = i - 0 - j + k
        // => sell1 - j + k
        //buy2 is max (buy2, sell1 - j (current prices[i])
        //sell2 = max(sell2, sell1 - j + k(current prices[i])
        //=>sell2 = max(sell2, buy2 (which is either buy2 or sell1 - j) + k)
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

}
