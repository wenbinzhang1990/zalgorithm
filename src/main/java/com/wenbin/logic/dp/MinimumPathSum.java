package com.wenbin.logic.dp;

/**
 * 最小路径和 https://leetcode-cn.com/problems/minimum-path-sum/
 */
public class MinimumPathSum {

  public int minPathSum(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int[][] dp = new int[grid.length + 1][grid[0].length + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = Integer.MAX_VALUE;
          continue;
        }

        if (i == 1 && j == 1) {
          dp[i][j] = grid[i - 1][j - 1];
          continue;
        }

        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
      }
    }

    return dp[grid.length][grid[0].length];
  }

  public int minPathSum2(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int[][] dp = new int[grid.length][grid[0].length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {

        if (i == 0 && j == 0) {
          dp[i][j] = grid[i][j];
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1] + grid[i][j];
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j] + grid[i][j];
        } else {
          dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
      }
    }

    return dp[grid.length - 1][grid[0].length - 1];
  }
}
