package com.wenbin.logic.dp;

import java.util.Arrays;

/**
 * 不同路径 https://leetcode-cn.com/problems/unique-paths/
 */
public class UniquePaths {

  public int uniquePaths(int m, int n) {
    if (m <= 1 || n <= 1) {
      return 1;
    }

    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (i == 1 && j == 1) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }

    return dp[m][n];
  }

  public int uniquePaths2(int m, int n) {
    if (m <= 1 || n <= 1) {
      return 1;
    }

    int[] dp = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[j] = dp[j - 1] + dp[j];
      }
    }

    return dp[n - 1];
  }
}
