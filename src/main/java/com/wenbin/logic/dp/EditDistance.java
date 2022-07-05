package com.wenbin.logic.dp;

/**
 * 编辑距离 https://leetcode-cn.com/problems/edit-distance/
 */
public class EditDistance {

  public static void main(String[] args) {
    EditDistance editDistance = new EditDistance();
    editDistance.minDistance("intention", "execution");
  }

  public int minDistance(String word1, String word2) {
    int length1 = word1.length();
    int length2 = word2.length();
    if (length1 * length2 == 0) {
      return length1 + length2;
    }

    int[][] dp = new int[length1 + 1][length2 + 1];
    for (int i = 1; i <= length1; i++) {
      dp[i][0] = i;
      for (int j = 1; j <= length2; j++) {
        dp[0][j] = j;
        dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1,
            dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)));
      }
    }

    return dp[length1][length2];
  }
}
