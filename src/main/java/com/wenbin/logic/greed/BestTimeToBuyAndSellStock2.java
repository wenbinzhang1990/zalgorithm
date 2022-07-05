package com.wenbin.logic.greed;

/**
 * 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStock2 {

  // 贪心
  public int maxProfitByGreed(int[] prices) {
    int maxprofit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        maxprofit += prices[i] - prices[i - 1];
      }
    }
    return maxprofit;
  }

  // dp
  public int maxProfitByDp(int[] prices) {
    if (prices.length == 0) {
      return 0;
    }

    int[] dp = new int[prices.length];
    for (int i = 1; i < prices.length; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] = Math.max(dp[i - 1], prices[i] - prices[j] + dp[j]);
      }
    }

    return dp[prices.length - 1];
  }

  public int maxProfitByDp2(int[] prices) {
    int len = prices.length;
    if (len < 2) {
      return 0;
    }

    // cash：持有现金
    // hold：持有股票
    // 状态数组
    // 状态转移：cash → hold → cash → hold → cash → hold → cash
    int[] cash = new int[len];
    int[] hold = new int[len];

    cash[0] = 0;
    hold[0] = -prices[0];

    for (int i = 1; i < len; i++) {
      // 这两行调换顺序也是可以的
      cash[i] = Math.max(cash[i - 1], hold[i - 1] + prices[i]);
      hold[i] = Math.max(hold[i - 1], cash[i - 1] - prices[i]);
    }
    return cash[len - 1];
  }
}
