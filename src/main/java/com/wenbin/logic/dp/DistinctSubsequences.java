package com.wenbin.logic.dp;

import java.util.Arrays;

/**
 * 不同的子序列 https://leetcode-cn.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {

  public int numDistinct(String s, String t) {
    int sLen = s.length();
    int tLen = t.length();
    if (sLen < tLen) {
      return 0;
    }

    int[][] dp = new int[tLen + 1][sLen + 1];
    Arrays.fill(dp[0], 1);
    for (int i = 1; i <= tLen; i++) {
      for (int j = 1; j <= sLen; j++) {
        if (t.charAt(i - 1) == s.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }

    return dp[tLen][sLen];
  }
}
