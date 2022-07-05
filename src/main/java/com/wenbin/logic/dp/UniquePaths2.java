package com.wenbin.logic.dp;

/**
 * 不同路径 II https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class UniquePaths2 {

  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0
        || obstacleGrid[0][0] == 1) {
      return 0;
    }

    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (obstacleGrid[i - 1][j - 1] == 1) {
          dp[i][j] = 0;
          continue;
        }
        if (i == 1 && j == 1) {
          dp[i][j] = 1;
        } else {
          dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
      }
    }

    return dp[m][n];
  }

  public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
    if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0
        || obstacleGrid[0][0] == 1) {
      return 0;
    }

    int m = obstacleGrid.length;
    int n = obstacleGrid[0].length;
    int[] dp = new int[n];
    dp[0] = 1;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (obstacleGrid[i][j] == 1) {
          dp[j] = 0;
          continue;
        }

        if (j > 0) {
          dp[j] = dp[j] + dp[j - 1];
        }
      }
    }

    return dp[n - 1];
  }
}
