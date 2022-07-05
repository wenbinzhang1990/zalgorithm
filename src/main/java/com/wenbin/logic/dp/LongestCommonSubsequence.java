package com.wenbin.logic.dp;

/**
 * 最长公共子序列 https://leetcode-cn.com/problems/longest-common-subsequence
 */
public class LongestCommonSubsequence {

  /**
   * 很精妙的暴力解法： 两指针从尾部开始，相同则加1，不相同则分裂，取分裂后结果更大的那个，最终拿到最大值
   */
  public int longestCommonSubsequenceByDfs(String text1, String text2) {
    return dfs(text1, text2, text1.length() - 1, text2.length() - 1);
  }

  public static void main(String[] args) {
    LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
    longestCommonSubsequence.longestCommonSubsequenceByDp("abcde", "ace");
  }

  public int longestCommonSubsequenceByDp(String text1, String text2) {
    int m = text1.length(), n = text2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <=m; i++) {
      for (int j = 1; j <=n; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[m][n];
  }

  private int dfs(String text1, String text2, int text1Index, int text2Index) {
    if (text1Index < 0 || text2Index < 0) {
      return 0;
    }

    if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
      return 1 + dfs(text1, text2, text1Index - 1, text2Index - 1);
    }

    return Math.min(dfs(text1, text2, text1Index - 1, text2Index),
        dfs(text1, text2, text1Index, text2Index - 1));
  }
}
