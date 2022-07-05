package com.wenbin.logic.dp;

import java.beans.FeatureDescriptor;

/**
 * 最佳买卖股票时机含冷冻期 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class BestTimeToBuyAndSellStockWithCoolDown {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int[] cashDp = new int[prices.length];
    int[] holdDp = new int[prices.length];
    int[] freezeDp = new int[prices.length];
    holdDp[0] = -prices[0];
    for (int i = 2; i < prices.length; i++) {
      cashDp[i] = Math.max(cashDp[i - 1], freezeDp[i - 1]);
      holdDp[i] = Math.max(holdDp[i - 1], cashDp[i - 1] - prices[i]);
      freezeDp[i] = holdDp[i - 1] + prices[i];
    }

    return Math.max(cashDp[prices.length - 1],freezeDp[prices.length-1]);
  }
}
