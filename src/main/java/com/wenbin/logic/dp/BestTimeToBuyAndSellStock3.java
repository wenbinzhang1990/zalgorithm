package com.wenbin.logic.dp;

/**
 * 买卖股票的最佳时机3 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
 */
public class BestTimeToBuyAndSellStock3 {

  public int maxProfit(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }
    int K = 2;
    int[][] dp = new int[prices.length][K + 1];
    for (int k = 1; k <= K; k++) {
      int min = prices[0];
      for (int i = 1; i < prices.length; i++) {
        min = Math.min(prices[i] - dp[i][k - 1], min);
        dp[i][k] = Math.max(dp[i - 1][k], prices[i] - min);
      }
    }

    return dp[prices.length - 1][K];
  }
}
