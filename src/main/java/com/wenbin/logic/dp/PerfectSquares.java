package com.wenbin.logic.dp;

/**
 * 完全平方数 https://leetcode-cn.com/problems/perfect-squares/
 */
public class PerfectSquares {

  public int numSquares(int n) {
    int sqrtNum = (int) Math.sqrt(n) + 1;
    int[] sqrt = new int[sqrtNum];
    for (int i = 1; i < sqrtNum; i++) {
      sqrt[i] = i * i;
    }

    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = n + 1;
      for (int j = 0; j < sqrt.length; j++) {
        if (i >= sqrt[j]) {
          dp[i] = Math.min(dp[i], dp[i - sqrt[j]] + 1);
        }
      }
    }

    return dp[n] == n + 1 ? -1 : dp[n];
  }

  public int numSquares2(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    for (int i = 1; i <= n; i++) {
      dp[i] = n + 1;
      for (int j = 1; i - j * j >= 0; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }

    return dp[n] == n + 1 ? -1 : dp[n];
  }
}
