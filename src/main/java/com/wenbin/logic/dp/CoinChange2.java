package com.wenbin.logic.dp;

/**
 * 零钱兑换 II https://leetcode-cn.com/problems/coin-change-2/
 */
public class CoinChange2 {

  public int change(int amount, int[] coins) {
    if (amount <= 0) {
      return 1;
    }

    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int j = 0; j < coins.length; j++) {
      for (int i = 1; i <= amount; i++) {
        if (i >= coins[j]) {
          dp[i] += dp[i - coins[j]];
        }
      }
    }

    return dp[amount];
  }
}
