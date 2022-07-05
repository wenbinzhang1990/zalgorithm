package com.wenbin.logic.string;

/**
 * 正则表达式匹配 https://leetcode-cn.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {

  public boolean isMatch(String s, String p) {
    int sLen = s.length();
    int pLen = p.length();
    boolean[][] dp = new boolean[sLen + 1][pLen + 1];
    dp[0][0] = true;

    for (int j = 1; j <= pLen; j++) {
      if (p.charAt(j - 1) == '*') {
        dp[0][j] = dp[0][j - 2];
      }
    }

    for (int i = 1; i <= sLen; i++) {
      for (int j = 1; j <= pLen; j++) {
        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
          dp[i][j] = dp[i - 1][j - 1];
        } else if (p.charAt(j - 1) == '*') {
          if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
            dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
          } else {
            dp[i][j] = dp[i][j - 2];
          }
        }
      }
    }

    return dp[sLen][pLen];
  }
}
