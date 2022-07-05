package com.wenbin.logic.dp;

/**
 * 买卖股票的最佳时机4 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class BestTimeToBuyAndSellStock4 {

  public int maxProfit(int k, int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    if (k >= prices.length / 2) {
      return greedy(prices);
    }

    int[] dp = new int[prices.length];
    for (int i =1; i <= k; i++) {
      int min = prices[0];
      for (int j = 1; j < prices.length; j++) {
        min = Math.min(prices[j] - dp[j], min);
        dp[j] = Math.max(dp[j - 1], prices[j] - min);
      }
    }

    return dp[prices.length - 1];
  }

  private int greedy(int[] prices) {
    int result = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] - prices[i - 1] > 0) {
        result += (prices[i] - prices[i - 1]);
      }
    }

    return result;
  }
}
