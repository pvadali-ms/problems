package leetcode.medium;

import org.junit.Test;

/**
 * Created by PV029500 on 11/1/2016.
 */
public class BuyAndSellStockIIITest {

    @Test
    public void buyAndSellStock() {
        BuyAndSellStockIII buyAndSellStockIII = new BuyAndSellStockIII();
        int[] prices = new int[]{7, 1, 5, 2, 7, 4, 9};
        System.out.println(buyAndSellStockIII.maxProfit(prices, 2));
    }

}