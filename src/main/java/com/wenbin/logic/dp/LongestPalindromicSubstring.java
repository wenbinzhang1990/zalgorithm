package com.wenbin.logic.dp;

/**
 * 最长回文子串  https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

  public String longestPalindrome(String s) {
    if (s.length() == 0) {
      return s;
    }

    int left = 0;
    int right = 0;
    boolean[][] dp = new boolean[s.length()][s.length()];
    int max = 0;
    for (int j = 0; j < s.length(); j++) {
      for (int i = 0; i <= j; i++) {
        if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          if (max < j - i) {
            max = j - i;
            left = i;
            right = j;
          }
        }
      }
    }

    return s.substring(left, right + 1);
  }

  public String longestPalindromeByCentral(String s) {
    if (s.length() == 0) {
      return s;
    }

    int min = 0, max = 0;
    for (int i = 0; i < s.length() * 2 - 1; i++) {
      int left = i / 2;
      int right = i / 2 + i % 2;
      while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        if (max - min < right - left) {
          max = right;
          min = left;
        }

        left--;
        right++;
      }
    }

    return s.substring(min, max + 1);
  }
}
