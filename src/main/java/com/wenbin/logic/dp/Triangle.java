package com.wenbin.logic.dp;

import java.util.List;

/**
 * 三角形最小路径和 https://leetcode-cn.com/problems/triangle/description/
 */
public class Triangle {

  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int n = triangle.size();
    int[][] dp = new int[n + 1][n + 1];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
      }
    }

    return dp[0][0];
  }

  public int minimumTotal2(List<List<Integer>> triangle) {
    if (triangle == null || triangle.size() == 0) {
      return 0;
    }

    int n = triangle.size();
    int[] dp = new int[n + 1];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = 0; j <= i; j++) {
        dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
      }
    }
    return dp[0];
  }
}
