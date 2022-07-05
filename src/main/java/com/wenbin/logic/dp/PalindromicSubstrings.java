package com.wenbin.logic.dp;

/**
 * 回文字串 https://leetcode-cn.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {

  public int countSubstrings(String s) {
    if (s.length() == 0) {
      return 0;
    }

    int result = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          result++;
        }
      }
    }

    return result;
  }

  public int countSubstringsByCentral(String s) {
    if (s.length() == 0) {
      return 0;
    }

    int result = 0;
    for (int i = 0; i < 2 * s.length() - 1; i++) {
      int left = i / 2;
      int right = i / 2 + i % 2;
      while (left >= 0 && right < s.length()) {
        if (s.charAt(left) != s.charAt(right)) {
          break;
        }
        result++;
        left--;
        right++;

      }
    }

    return result;
  }
}
