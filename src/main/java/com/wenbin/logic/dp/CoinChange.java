package com.wenbin.logic.dp;

/**
 * 零钱兑换 https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

  public static void main(String[] args) {
    CoinChange coinChange = new CoinChange();
    coinChange.coinChange(new int[]{1, 2, 5}, 11);
  }

  public int coinChange(int[] coins, int amount) {
    if (amount < 1) {
      return -1;
    }

    int[] dp = new int[amount + 1];
    for (int i = 1; i <= amount; i++) {
      dp[i] = amount + 1;
      for (int j = 0; j < coins.length; j++) {
        if (i - coins[j] >= 0) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }

    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }
}
