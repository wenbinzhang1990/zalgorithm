package com.wenbin.logic.dp;

/**
 * 买卖股票的最佳时机 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int[] dp = new int[prices.length];
    int minPrice = prices[0];
    for (int i = 1; i < prices.length; i++) {
      minPrice = Math.min(minPrice, prices[i]);
      dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
    }

    return dp[prices.length - 1];
  }
}
