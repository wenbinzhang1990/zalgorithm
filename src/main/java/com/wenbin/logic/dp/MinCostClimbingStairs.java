package com.wenbin.logic.dp;

/**
 * 使用最小花费爬楼梯 https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

  public int minCostClimbingStairs(int[] cost) {
    if (cost == null || cost.length == 0) {
      return 0;
    }

    int len = cost.length;
    int[] dp = new int[len + 1];
    for (int i = 2; i <= len; i++) {
      dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
    }

    return dp[len];
  }
}
