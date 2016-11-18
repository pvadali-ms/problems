package leetcode.medium;

/**
 * Created by PV029500 on 11/1/2016.
 */
public class BuyAndSellStockIII {
    /*
        Brute force solution is to iteration k times: for each i in k, iterate j = 0 to length and k = j to length to find ith pair
     */
    public int maxProfit(int[] prices, int limit) {
        int buy = prices[0];
        int[] aux = new int[prices.length];
        for (int k = 1; k < prices.length; k++) {
            if (prices[k] < prices[k - 1]) {
                buy = prices[k];
                aux[k] = 0;
            } else {
                aux[k] = prices[k] - buy;
            }
        }

        int max = 0;
        for (int i = 1; i < limit; i++) {
            for (int j = 0; j < aux.length; j++) {
                for (int k = j + 1; k < aux.length; k++) {
                    max = Math.max(max, aux[j] + aux[k]);
                    if (max == aux[j] + aux[k]) {
                        aux[j] = 0;
                        aux[k] = max;
                    }
                }
            }
        }
        return max;
    }
}
