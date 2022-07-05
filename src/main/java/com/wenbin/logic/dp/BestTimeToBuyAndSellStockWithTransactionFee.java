package com.wenbin.logic.dp;

/**
 * 买卖股票的最佳时机含手续费 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

  public int maxProfitByDp(int[] prices, int fee) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }

    int[] cash = new int[prices.length];
    int[] holdCash = new int[prices.length];
    cash[0] = 0;
    holdCash[0] = -prices[0];
    for (int i = 1; i < prices.length; i++) {
      cash[i] = Math.max(cash[i - 1], holdCash[i - 1] + prices[i] - fee);
      holdCash[i] = Math.max(holdCash[i - 1], cash[i - 1] - prices[i]);
    }

    return cash[prices.length - 1];
  }

  public int maxProfitByGreed(int[] prices, int fee) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }

    int maxprofit = 0;
    int min = prices[0];
    for (int i = 1; i < prices.length; i++) {
      if (min > prices[i]) {
        min = prices[i];
      }

      if (prices[i] - fee > min) {
        maxprofit += prices[i] - min - fee;
        min = prices[i] - fee;
      }
    }

    return maxprofit;
  }
}
